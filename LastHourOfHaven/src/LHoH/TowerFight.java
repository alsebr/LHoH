package LHoH;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import HeroAbilitisPackage.HeroAbility_HowlOfTheWolf;
import ItemPackage.Item_Casket;
import ItemPackage.Item_Key1;
import ItemPackage.Item_Key2;
import ItemPackage.Item_Plague;
import ItemPackage.Item_chest;
import ItemPackage.Item_lamp;

public class TowerFight extends JPanel {
	Image bckground = null;
	int lvl;

	public double bossPower;
	String bossName;
	double winR;
	double powerH = 0;
	int status = 0; // 0 - nohere, 1 - battle, 2- win
	double ttl;
JButton endTower;
	
	public TowerFight() {
		setSize(700, 450);
		setLayout(null);
		setOpaque(false);
		// setBorder(BorderFactory.createLineBorder(Color.green));
		endTower=new JButton();
		String tmptext;
		
			tmptext="Окончить бой";
		
		
			endTower.setBounds(550, 400, 121, 30);
			endTower.setOpaque(false);
			endTower.setText(tmptext);
				
			endTower.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    		  endTowerBattle();
	    	  }
	    	});
		
		
	}

	void endTowerBattle()
	{
		LHoH.gameScreen.bottomInfo.chat.addTextChat("Вы покидаете Бесконечную башню");
		LHoH.gameScreen.player.setTowerProgress (lvl,winR);
		status=0;
		LHoH.gameScreen.towerPanel.activateTowerChoizeScreen();
	}
	
	void update(){
		if (status==1){
					
					if(lvl==2){
						bossPower=bossPower+(double)20/60;
					}
					
					powerH=0;
					ttl-=(double)1/60;
					if (ttl<=0)status=2;
					for (Hero hero : LHoH.gameScreen.heroStock.allScope) {
					if ((hero.getZone()==1)&&(hero.status==1))	{
						powerH+=hero.getPower();
					}
					}
				
				double winRT;
				double power=bossPower;
				double speed=0.0005;
				double delta=0;
				delta=(double)powerH/power;
				
				if (lvl==1){	Hero tmphero=LHoH.gameScreen.heroStock.getRandomAliveHero();
							if ((winR<0.25)&&(winR+delta*speed>=0.25)){
								LHoH.gameScreen.bottomInfo.chat.addTextChat("Вы получили награду за битву с "+bossName+" (25%)");
								LHoH.gameScreen.itemStock.allScope.add(new Item_Casket());
								
							
								LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_HowlOfTheWolf(tmphero.getId(),-27));;
								LHoH.gameScreen.bottomInfo.chat.addTextChat("Раздается чудовищный вой Лютоволка,"+tmphero.name+" замирает в ужасе");
							}
							if ((winR<0.50)&&(winR+delta*speed>=0.50)){
								LHoH.gameScreen.bottomInfo.chat.addTextChat("Вы получили награду за битву с "+bossName+" (50%)");
								LHoH.gameScreen.itemStock.allScope.add(new Item_chest(0));
								LHoH.gameScreen.itemStock.allScope.add(new Item_Key1());
								LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_HowlOfTheWolf(tmphero.getId(),-29));;
								LHoH.gameScreen.bottomInfo.chat.addTextChat("Раздается чудовищный вой Лютоволка,"+tmphero.name+" замирает в ужасе");
							}
							if ((winR<0.75)&&(winR+delta*speed>=0.75)){
								LHoH.gameScreen.bottomInfo.chat.addTextChat("Вы получили награду за битву с "+bossName+" (75%)");
								LHoH.gameScreen.itemStock.allScope.add(new Item_Plague(2));
								LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_HowlOfTheWolf(tmphero.getId(),-32));;
								LHoH.gameScreen.bottomInfo.chat.addTextChat("Раздается чудовищный вой Лютоволка,"+tmphero.name+" замирает в ужасе");
							}
							winR+=delta*speed;
							if (winR>=1) {
								winR=1;
								status=2;
								//hero1.setStatus(2);
								//winR=0.7;
								//bossPower=6666;
								LHoH.gameScreen.bottomInfo.chat.addTextChat("Нами окончательно повержен "+bossName);
								LHoH.gameScreen.itemStock.allScope.add(new Item_Key2());
								LHoH.gameScreen.itemStock.allScope.add(new Item_lamp());
							}
				}
				
				if (lvl==0){
					if ((winR<0.25)&&(winR+delta*speed>=0.25)){
						LHoH.gameScreen.bottomInfo.chat.addTextChat("Вы получили награду за битву с "+bossName+" (25%)");
						LHoH.gameScreen.itemStock.allScope.add(new Item_Casket());
					}
					if ((winR<0.50)&&(winR+delta*speed>=0.50)){
						LHoH.gameScreen.bottomInfo.chat.addTextChat("Вы получили награду за битву с "+bossName+" (50%)");
						LHoH.gameScreen.itemStock.allScope.add(new Item_Key1());
					}
					if ((winR<0.75)&&(winR+delta*speed>=0.75)){
						//LHoH.gameScreen.bottomInfo.chat.addTextChat("Вы получили награду за битву с "+bossName+" (75%)");
						//LHoH.gameScreen.itemStock.allScope.add(new Item_Casket());
					}
					winR+=delta*speed;
					if (winR>=1) {
						winR=1;
						status=2;
						//hero1.setStatus(2);
						//winR=0.7;
						//bossPower=6666;
						LHoH.gameScreen.bottomInfo.chat.addTextChat("Нами окончательно повержен "+bossName);
						LHoH.gameScreen.itemStock.allScope.add(new Item_PowerUp(1));
						LHoH.gameScreen.player.addLocationNewTier(10000);
						LHoH.gameScreen.player.addHeroNewTier(10000);
					}
		}
				
				if (lvl==2){
					if ((winR<0.25)&&(winR+delta*speed>=0.25)){
						LHoH.gameScreen.bottomInfo.chat.addTextChat("Вы получили награду за битву с "+bossName+" (25%)");
						LHoH.gameScreen.itemStock.allScope.add(new Item_Soul());
					}
					if ((winR<0.50)&&(winR+delta*speed>=0.50)){
						LHoH.gameScreen.bottomInfo.chat.addTextChat("Вы получили награду за битву с "+bossName+" (50%)");
						LHoH.gameScreen.itemStock.allScope.add(new Item_Soul());
					}
					if ((winR<0.75)&&(winR+delta*speed>=0.75)){
						LHoH.gameScreen.bottomInfo.chat.addTextChat("Вы получили награду за битву с "+bossName+" (75%)");
						LHoH.gameScreen.itemStock.allScope.add(new Item_Soul());
					}
					winR+=delta*speed;
					if (winR>=1) {
						winR=1;
						status=2;
						//hero1.setStatus(2);
						//winR=0.7;
						//bossPower=6666;
						LHoH.gameScreen.bottomInfo.chat.addTextChat("Нами окончательно повержен "+bossName);
						LHoH.gameScreen.itemStock.allScope.add(new Item_LegionGorn());
					}
		}
				
		}
		
		
	}

	void init(int inLvl) {
		
		if (inLvl==0){
			
			
			lvl = inLvl;
			try {
				bckground = ImageIO.read(new File("data/image/bos/bos3.gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			addComp();
			bossName = "Болотный дух";
			winR = 0.03;
			bossPower = 80;
			status = 1;
			ttl=1*120;
			}
		
		
		if (inLvl==1){
			
		
		lvl = inLvl;
		try {
			bckground = ImageIO.read(new File("data/image/bos/bos5.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		addComp();
		bossName = "Лютоволк";
		winR = 0.03;
		bossPower = 250;
		status = 1;
		ttl=1*59;
		}
		if (inLvl==2){
			
			lvl = inLvl;
			try {
				bckground = ImageIO.read(new File("data/image/bos/bos1.gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			addComp();
			bossName = "Тираэль — архангел Высоких Небес";
			winR = 0.03;
			bossPower = 600;
			status = 1;
			ttl=1*30;			
		}
	}

	void addComp() {
		removeAll();
		add(LHoH.gameScreen.heroStockScroll);
		add(endTower);
	}

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(new Color(255, 1, 1, 77));
		g.drawImage(bckground, 0, 0, null);

		g2.fillRect(0, (int) (450 * (1 - winR)), 700, (int) (450 * (winR)));

		g.setColor(Color.red);
		g2.setFont(new Font("Arial", Font.BOLD, 22));
		g2.drawString(bossName, 290, 30);

		g.setColor(Color.red);
		g2.setFont(new Font("Arial", Font.BOLD, 30));

		g2.drawString("Мощь: "+Integer.toString((int) bossPower), 470, 65);

		g2.drawString(Integer.toString((int) powerH), 110, 425);

		
		int min,sec;
		min=(int)(ttl/60);
		sec= (int)(ttl-min*60);
		
		g2.drawString("Время: "+min +":"+sec, 470, 95);
		
		
		g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(2));
        for (int i = 0; i < 4; i++) {
        	g2.setStroke(new BasicStroke(2));
        	if (i==2) g2.setStroke(new BasicStroke(4));
        	g2.draw(new Line2D.Double(670, getHeight()/4*i, 700, getHeight()/4*i));	
		}
        
        
		
	}

}
