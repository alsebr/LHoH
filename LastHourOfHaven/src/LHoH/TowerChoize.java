package LHoH;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		//setBorder(BorderFactory.createLineBorder(Color.red));
		setLayout(null);
		try {
			bckground = ImageIO.read(new File("data/image/bckground/tower.gif"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			imageKey1 = ImageIO.read(new File("data/image/item/item9_p.gif"));
		} catch (IOException e) {
		}
		try {
			imageKey2 = ImageIO.read(new File("data/image/item/key2.gif"));
		} catch (IOException e) {
		}
		init();
	}
	
	
	void goFightTower(int inLvl){
		if (inLvl!=0){
		
			if (LHoH.gameScreen.itemStock.getItem("Демонический ключ")){
				LHoH.gameScreen.bottomInfo.chat.addTextChat("Вы вступаете на "+inLvl +" этаж Бесконечной башни, использовав Демонический ключ");
				LHoH.gameScreen.towerPanel.towerFight.init(inLvl);
				LHoH.gameScreen.towerPanel.activateTowerFightScrenn();
			}else{
				LHoH.gameScreen.bottomInfo.chat.addTextChat("Для входа в Бесконечную башню вам нужен Демонический ключ");
			}
		}else{
			LHoH.gameScreen.bottomInfo.chat.addTextChat("Вы вступаете на "+inLvl +" этаж Бесконечной башни");
			LHoH.gameScreen.towerPanel.towerFight.init(inLvl);
			LHoH.gameScreen.towerPanel.activateTowerFightScrenn();
		}
			
			
		
	}
	
	JButton[] arrayButton=new JButton[10];
	
	void init(){
		for (int i = 0; i < 5; i++) {
			int tmpTPL=LHoH.gameScreen.player.getTowerLvlProgress(i);
			JButton tmpJB=new JButton();
			String tmptext;
			if (tmpTPL==-1){
				tmpJB.setEnabled(false);
				tmptext=(i)+" этаж ";
			}else{
				tmptext=(i)+" этаж "+" ("+tmpTPL+"%)";
			}
			
			tmpJB.setBounds(40, 220+34*i, 121, 30);
			tmpJB.setOpaque(false);
			tmpJB.setText(tmptext);
			final int  lvlNum=i;
			
			tmpJB.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e) {
		    		  goFightTower(lvlNum);
		    	  }
		    	});
			arrayButton[i]=tmpJB;
					
			add(tmpJB);
			
			
		}
	}
	
	void buttonUpgrade(){
		for (int i = 0; i < 5; i++) {
			int tmpTPL=LHoH.gameScreen.player.getTowerLvlProgress(i);
			JButton tmpJB=arrayButton[i];
			String tmptext;
			
			if (tmpTPL==-1){
				tmpJB.setEnabled(false);
				tmptext=(i)+" этаж ";
			}else{
				tmpJB.setEnabled(true);
				tmptext=(i)+" этаж "+" ("+tmpTPL+"%)";
			}
			
			tmpJB.setBounds(40, 220+34*i, 121, 30);
			tmpJB.setOpaque(false);
			tmpJB.setText(tmptext);
			
			
			
			
			
			
			
		}
	}
	
	void update(){
		buttonUpgrade();
	}
	
	public void paintComponent(Graphics g) {
		revalidate();	
		g.drawImage(bckground, 0, 0, null);
		
		g.drawImage(imageKey1, 50, 100, null);
		//g.drawImage(imageKey2, 0, 200, null);
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.PLAIN, 30)); 
		
		g.drawString("Бесконечная башня", 20, 55);
		}
}
