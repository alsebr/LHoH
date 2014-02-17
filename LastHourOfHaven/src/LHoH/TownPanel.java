package LHoH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class TownPanel extends JPanel{
	Image bckground=null;
	Building buildPalace;
	Building buildTavern;
	
	class Building extends JPanel{
		public Building() {
			setSize(170,100);
			setPreferredSize(new Dimension(170	,100));
			setLayout(new FlowLayout());
			
			setBorder(BorderFactory.createLineBorder(Color.black));
		}
	}
	
public TownPanel() {
	setSize(700,450);
	
	setLayout(new FlowLayout());
	
	setBorder(BorderFactory.createLineBorder(Color.black));
	try {
		bckground = ImageIO.read(new File("data/image/bckground/hell.gif"));
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	buildPalace= new Building();
	buildTavern=new Building();
	
	add(buildTavern);
	
	add(buildPalace);
	
	
}

public void paintComponent(Graphics g) {
	//removeAll();	
	//add (LHoH.gameScreen.heroStock);
	//add (LHoH.gameScreen.locationScope);
		g.drawImage(bckground, 0, 0, null);
		revalidate();
	}
}
