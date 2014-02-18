package LHoH;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class TowerFight extends JPanel{
	Image bckground=null;
	public TowerFight() {
		setSize(700, 450);
		setLayout(null);
		setOpaque(false);
		setBorder(BorderFactory.createLineBorder(Color.green));
		try {
			bckground = ImageIO.read(new File("data/image/bckground/item.gif"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void update(){
		
	}
	
	public void paintComponent(Graphics g) {
			g.drawImage(bckground, 0, 0, null);
		}
}
