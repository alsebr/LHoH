package LHoH;

import java.awt.datatransfer.StringSelection;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;



public class Hero extends JPanel implements DragGestureListener, DragSourceListener{
	DragSource dragSource;

	double power,exp, ttl;
	protected String name,classH;
	Image image;
	int status; // 1 - live, 0 - dead, 2 - strage
	int lvl;
	private int zone;
	int id;
	
	double deltaExp;
	double deltaPower;
	

	
	//int[] arrayLvlExp = new int[] {0,10,40,100,150};
	//double[] arrayLvlPower = new double[] {10,20,40,50,70};
	public Hero(String name, double power,double exp,double ttl, String  classH, int zoneId, Image inImage, double inDeltaExp, double inDeltaPower){
		setSize(80	,105);
		setPreferredSize(new Dimension(80,105));
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		Random randomGenerator = new Random();
	    id=randomGenerator.nextInt(32000);
	    
	    
	    
	    setZone(2);
		this.name=name;
		this.power=power;
		//this.exp=exp;
		this.exp=1;
		this.ttl=ttl;
		this.classH=classH;
		status=1;
		lvl=1;
		zone=zoneId;
	
		
		
		deltaExp=inDeltaExp;
		deltaPower=inDeltaPower;
		
		//switch (classH) {
		//case "воин":
			
				image = inImage;
			
			//break;

	//	default:
	//		break;
	//	}
			dragSource = new DragSource();
			dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
			
	}
	

	
	void addPower (double addP){
		power+=addP;
		System.out.println(power);
	}
	void addExp (double addExp){
		exp+=addExp;
	}
	
	protected void Update (){
		if (status==1) ttl-=0.017;
		if (ttl<=0) status=0;
		
		double expNeedExp=deltaExp*((double)lvl + (double)lvl*lvl/20);
		
		if (expNeedExp<exp ){
			power+=deltaPower;
			lvl+=1;
			LHoH.gameScreen.bottomInfo.chat.addTextChat(name+" достиг "+lvl+" уровня, его мощь теперь "+(int)power);
		}
		
		//power=exp; //!!
		String tmptext;
		tmptext="<html> <p align=center>"+name+"</p>";
		tmptext+="<p> Lvl:"+(int)lvl;
		tmptext+="<p> Exp:"+(int)exp;
		tmptext+="<p> Power:"+(int)power;
		
		int min,sec;
		min=(int)(ttl/60);
		sec= (int)(ttl-min*60);
		
		tmptext+="<p> Left time:"+min +":"+sec;
		setToolTipText(tmptext);
	}
	
	void setStatus(int inStatus){
		status=inStatus;
	}
	
	void reDrow (Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g.drawImage(image, 0, 0, null);
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(2));
		
		g2.setFont(new Font("Arial", Font.BOLD, 16)); 
		
		int min,sec;
		min=(int)(ttl/60);
		sec= (int)(ttl-min*60);
		
		switch (status) {
		case 0:
			g2.drawString("DEAD", 5, 15);
			g2.drawString(Integer.toString((int)power), 5, 98);
			break;
		case 1:
			g2.drawString(min +":"+sec, 5, 15);
			g2.drawString(Integer.toString((int)power), 15, 98);
			break;
		case 2:
			g2.drawString("Страж", 15, 50);
			g2.drawString(min +":"+sec, 5, 15);
			g2.drawString(Integer.toString((int)power), 5, 98);
			
			break;
		default:
			break;
		}

		
		//exp
		g2.setColor(Color.red);
		
		double expNeedExp=deltaExp*((double)lvl + (double)lvl*lvl/20);
		double expNeedExpPr=deltaExp*((double)(lvl-1) + (double)(lvl-1)*(lvl-1)/20);
		g2.fillRect(3, 10,3 ,(int)(90*(exp-expNeedExpPr)/(expNeedExp-expNeedExpPr)));
	}

	public void paintComponent(Graphics g) {
		
		
	 
		//removeAll();
		//Graphics2D g2 = (Graphics2D) g;
	    //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    reDrow(g);
	}
	
	public void dragGestureRecognized(DragGestureEvent evt) {
		if (status==1){
		Transferable transferable = new StringSelection(Integer.toString(id));//!!!!!
		dragSource.startDrag(evt, DragSource.DefaultCopyDrop, transferable, this);
		}
		   }
		
		    public void dragEnter(DragSourceDragEvent evt) {
		
		// Called when the user is dragging this drag source and enters the drop target
		
		System.out.println("Drag enter");
		
		    }
		
		    public void dragOver(DragSourceDragEvent evt) {
		
		// Called when the user is dragging this drag source and moves over the drop target
		
		System.out.println("Drag over");
		
		    }
		
		    public void dragExit(DragSourceEvent evt) {
		
		// Called when the user is dragging this drag source and leaves the drop target
		
		System.out.println("Drag exit");
		
		    }
		
		 
		
		    public void dropActionChanged(DragSourceDragEvent evt) {
		
		// Called when the user changes the drag action between copy or move
		
		System.out.println("Drag action changed");
		
		    }
		
		    public void dragDropEnd(DragSourceDropEvent evt) {
		
		// Called when the user finishes or cancels the drag operation
		
		System.out.println("Drag action End");
		
		    }
			public int getZone() {
				return zone;
			}
			public void setZone(int zone) {
				this.zone = zone;
			}
		
		 
		
		  


}
