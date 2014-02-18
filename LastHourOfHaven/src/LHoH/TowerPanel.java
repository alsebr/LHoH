package LHoH;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TowerPanel extends JPanel{
	Image bckground=null;
	public TowerPanel() {
setSize(700, 450);
		
		setLayout(null);
//		setBorder(BorderFactory.createLineBorder(Color.green));
		
		
		setOpaque(false);
		
		addComp();
		
		try {
			bckground = ImageIO.read(new File("data/image/bckground/tower.gif"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void addComp(){
		
	}
	
	public void paintComponent(Graphics g) {

			g.drawImage(bckground, 0, 0, null);
		}
}
