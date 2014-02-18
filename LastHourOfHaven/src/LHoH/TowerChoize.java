package LHoH;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TowerChoize extends JPanel{
	Image bckground=null;
	Image imageKey1,imageKey2;
	public TowerChoize() {
		setSize(700, 450);
		setLayout(null);
		setOpaque(false);
		setBorder(BorderFactory.createLineBorder(Color.red));
		setLayout(new FlowLayout());
		try {
			bckground = ImageIO.read(new File("data/image/bckground/item.gif"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			imageKey1 = ImageIO.read(new File("data/image/item/key1.gif"));
		} catch (IOException e) {
		}
		try {
			imageKey2 = ImageIO.read(new File("data/image/item/key2.gif"));
		} catch (IOException e) {
		}
		init();
	}
	
	
	void init(){
		for (int i = 0; i < 7; i++) {
			int tmpTPL=LHoH.gameScreen.player.getTowerLvlProgress(i);
			JButton tmpJB=new JButton();
			String tmptext;
			if (tmpTPL==-1){
				tmpJB.setEnabled(false);
				tmptext="Lavel "+(i+1);
			}else{
				tmptext="Lavel "+(i+1)+" ("+tmpTPL+"%)";
			}
			tmpJB.setText(tmptext);
			add(tmpJB);
			
			
		}
	}
	
	void update(){
		
	}
	
	public void paintComponent(Graphics g) {
		revalidate();	
		g.drawImage(bckground, 0, 0, null);
		g.drawImage(imageKey1, 0, 100, null);
		g.drawImage(imageKey2, 0, 200, null);
		}
}
