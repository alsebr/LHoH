package LHoH;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TowerPanel extends JPanel {
	Image bckground = null;

	
	TowerChoize towerChoize;
	TowerFight towerFight;
	

	
	public TowerPanel() {
		setSize(700, 450);
		setLayout(null);
		setOpaque(false);

		
		towerChoize= new TowerChoize();
		towerFight= new TowerFight();
		
		activateTowerChoizeScreen();
		
		addComp();

		try {
			bckground = ImageIO
					.read(new File("data/image/bckground/tower.gif"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void activateTowerChoizeScreen(){
		removeAll();
		add(towerChoize);
	}
	
	void activateTowerFightScrenn(){
		removeAll();
		add(towerFight);
	}

	void addComp() {

	}
	
	void update(){
		towerChoize.update();
		towerFight.update();
	}

	public void paintComponent(Graphics g) {

		g.drawImage(bckground, 0, 0, null);
	}
}
