package LHoH;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.dnd.Autoscroll;
import java.io.File;
import java.io.IOException;
import java.util.prefs.BackingStoreException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.AttributeSet.FontAttribute;

public class BottomInfo extends JPanel{
	class ResInfo extends JPanel{
		Image image1,image2,image3,image4;
		public ResInfo() {
			setSize(199,149);
			setPreferredSize(new Dimension(199,149));
			//setBorder(BorderFactory.createLineBorder(Color.green));
			try {
				image1 = ImageIO.read(new File("data/image/interface/1_30_inverse.gif"));
				image2 = ImageIO.read(new File("data/image/interface/3_30_inverse.gif"));
				image3 = ImageIO.read(new File("data/image/interface/2_30.gif"));
				image4 = ImageIO.read(new File("data/image/interface/4_30_inverse.gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void paintComponent(Graphics g) {
			
			
			Graphics2D g2 = (Graphics2D) g;
		    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		    g.drawImage(image1, 1, 20, null);
		    g.drawImage(image2, 1, 70, null);
		    g.drawImage(image3, 90, 20, null);
		    g.drawImage(image4, 90, 70, null);
		    
			g2.setFont(new Font("Arial", Font.BOLD, 25)); 
			g2.setColor(Color.white);
				int dr=25;
				g2.drawString(Integer.toString((int)LHoH.gameScreen.player.gold) , 40	, 20+dr);
				g2.drawString(Integer.toString((int)LHoH.gameScreen.player.soul) , 40	, 70+dr);
				g2.drawString(Integer.toString((int)LHoH.gameScreen.player.tear) , 125	, 20+dr);
				
				
				int min,sec;
				min=(int)(LHoH.gameScreen.player.ttl/60);
				sec= (int)(LHoH.gameScreen.player.ttl-min*60);
				
				
				g2.drawString(min +":"+sec, 125, 70+dr);
				
		    //   reDrow(g);
		    
		}
	}
	class Chat extends JTextArea{
		Chat(){
			setSize(500,122);
			setPreferredSize(new Dimension(550,122));
			//setBorder(BorderFactory.createLineBorder(Color.red));
			
			
			setEditable(false);
			setOpaque(false);
			
			setForeground(Color.white);
			//setFont(new Font("Arial", FontAttribute., 14));
	//		setLineWrap(true);
//			setWrapStyleWord(true);
		}
		
		void addTextChat (String text){
		//	getTi
			
			int min,sec;
			min=(int)(LHoH.gameScreen.player.ttl/60);
			sec= (int)(LHoH.gameScreen.player.ttl-min*60);
			
				
			
			//append("\n"+min +":"+sec +"     "+ text);
			setText(+min +":"+sec +"     "+ text+"\n"+getText());
		}
	}
	ResInfo resInfo= new ResInfo();
	Chat chat= new Chat();
	Image bckground;
	BottomInfo(){
		
	
	setSize(800,150);
	setPreferredSize(new Dimension(800, 150));
	setLayout(new FlowLayout());
	//setBorder(BorderFactory.createLineBorder(Color.BLUE));
	
	try {
		bckground = ImageIO.read(new File("data/image/bckground/bot.gif"));
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	add (resInfo);
	add (chat);
	}
	public void paintComponent(Graphics g) {
		//removeAll();	
		//add (LHoH.gameScreen.heroStock);
		//add (LHoH.gameScreen.locationScope);
			g.drawImage(bckground, 0, 0, null);
		//setBackground(Color.black);
			
		}
}
