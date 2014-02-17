package LHoH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ItemPanel extends JPanel {
	Image bckground=null;
	ItemPanel() {
		setSize(700, 450);
		
		setLayout(null);
//		setBorder(BorderFactory.createLineBorder(Color.green));
		
		add(LHoH.gameScreen.itemStock);
		setOpaque(false);
		
		try {
			bckground = ImageIO.read(new File("data/image/bckground/item.gif"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		//removeAll();	
		//add (LHoH.gameScreen.heroStock);
		//add (LHoH.gameScreen.locationScope);
			g.drawImage(bckground, 0, 0, null);
		}

}
