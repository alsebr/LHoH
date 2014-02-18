package LHoH;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Item extends JPanel implements MouseListener{
	int id;
	Image image;
	double charge_now=0;
	double charge_max=0;
	private String name="ERROR";
	public Item() {
		setSize(80	,105);
		setPreferredSize(new Dimension(80,105));
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		//image = inImage;
		
		Random randomGenerator = new Random();
	    id=randomGenerator.nextInt(32000);
	    
	    this.addMouseListener(this);
	}
	
	void activateItem (){
		
	}
	
	void checkCharge (){
		
	}
	
	void update (){
		checkCharge();
		
		
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	
	void reDrow (Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		
		//g.setColor(new Color(255,255,255,128));
		//g.fillRect(0, 0,80 ,105);
		
		g.drawImage(image, 0, 0, null);
		
	}
	
	int getId(){
		return id;
	}
	
	void SelfDestroy (){
		for (Item item : LHoH.gameScreen.itemStock.allScope) {
    		if (item.getId()==getId())	{
    			LHoH.gameScreen.itemStock.allScope.remove(item);
    		}
    	}
	}

	public void paintComponent(Graphics g) {
		
		
	 
		//removeAll();
		//Graphics2D g2 = (Graphics2D) g;
	    //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    reDrow(g);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getClickCount()==2){
			
		
		activateItem();
		}
		
	}

}
