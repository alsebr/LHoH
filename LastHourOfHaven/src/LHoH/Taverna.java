package LHoH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Taverna extends JPanel{
	
	
	double ttlUpdate_reload=60;
	double ttlUpdate_now=ttlUpdate_reload;
	
	class HeroForTrade extends JPanel{
		Hero hero;
		JLabel heroInf;
		JButton heroBuy;
		int heroCostGold;
		int heroCostSoul;
		int heroCostTear;
		Image image1,image2,image3;
		
		double dispersion=0.2;
		double rndModif(double val, double disp){
			Random randomGenerator = new Random();
			
			return val+(((double)randomGenerator.nextInt(1000)-500)/500*disp*val);
		}
		
		HeroForTrade (){
			setSize(640,120);
			setPreferredSize(new Dimension(640, 120));
			setLayout(null);
			setBorder(BorderFactory.createLineBorder(Color.black));
			
			
			
			
			
			
			try {
				image1 = ImageIO.read(new File("data/image/interface/1_30.gif"));
				image2 = ImageIO.read(new File("data/image/interface/3_30.gif"));
				image3 = ImageIO.read(new File("data/image/interface/2_30.gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String nname;
			double nexp;
			int nlvl;
			double npower,nttl;
			Image nimage;
			int nheroCostGold,nheroCostSoul,nheroCostTear;

double inDeltaExp;
double inDeltaPower;
			
			Random random = new Random();
			int count=random.nextInt(9);
			
			nexp=1;
			nlvl=1;
			
			//count=1;
			
			nname="error";
			npower=45+random.nextInt(25);
			nimage=null;
			try {
				nimage = ImageIO.read(new File("data/image/hero/demon9.gif"));
			} catch (IOException e) {
			}
			nheroCostGold=20+random.nextInt(8);
			nheroCostSoul=5+random.nextInt(3);
			nheroCostTear=0;//+random.nextInt(1);
			nttl=140+random.nextInt(40);
			inDeltaExp=10;
			inDeltaPower=4;
			
			switch (count) {
			case 0:
				nname="Имп";
				npower=25;
				nimage=null;
				try {
					nimage = ImageIO.read(new File("data/image/hero/demon9.gif"));
				} catch (IOException e) {
				}
				nheroCostGold=10;
				nheroCostSoul=1;//+random.nextInt(3);
				nheroCostTear=0;//+random.nextInt(1);
				nttl=60;
				inDeltaExp=10;
				inDeltaPower=4;
				break;
			case 1:
				nname="Малая тень";
				npower=12;
				nimage=null;
				try {
					nimage = ImageIO.read(new File("data/image/hero/demon4.gif"));
				} catch (IOException e) {
				}
				nheroCostGold=10;
				nheroCostSoul=1;
				nheroCostTear=0;//+random.nextInt(1);
				nttl=70;
				inDeltaExp=8;
				inDeltaPower=6;
				break;
			case 2:
				nname="Малый демон";
				npower=5;
				nimage=null;
				try {
					nimage = ImageIO.read(new File("data/image/hero/demon5.gif"));
				} catch (IOException e) {
				}
				nheroCostGold=13;
				nheroCostSoul=1;
				nheroCostTear=0;//+random.nextInt(1);
				nttl=120;
				inDeltaExp=8;
				inDeltaPower=7;
				break;

			case 3:
				nname="Порождение";
				npower=15;
				nimage=null;
				try {
					nimage = ImageIO.read(new File("data/image/hero/demon11.gif"));
				} catch (IOException e) {
				}
				nheroCostGold=9;
				nheroCostSoul=1;
				nheroCostTear=0;//+random.nextInt(1);
				nttl=70;
				inDeltaExp=9;
				inDeltaPower=6;
				break;
			case 4:
				nname="Ифрит";
				npower=50;
				nimage=null;
				try {
					nimage = ImageIO.read(new File("data/image/hero/demon12.gif"));
				} catch (IOException e) {
				}
				nheroCostGold=40;
				nheroCostSoul=2;
				nheroCostTear=0;//+random.nextInt(1);
				nttl=300;
				inDeltaExp=30;
				inDeltaPower=17;
				break;
			case 5:
				nname="Цербер";
				npower=40;
				nimage=null;
				try {
					nimage = ImageIO.read(new File("data/image/hero/demon13.gif"));
				} catch (IOException e) {
				}
				nheroCostGold=25;
				nheroCostSoul=4;
				nheroCostTear=0;//+random.nextInt(1);
				nttl=280;
				inDeltaExp=30;
				inDeltaPower=15;
				break;
				
			case 6:
				nname="Крестоносец";
				npower=90;
				nimage=null;
				try {
					nimage = ImageIO.read(new File("data/image/hero/demon14.gif"));
				} catch (IOException e) {
				}
				nheroCostGold=70;
				nheroCostSoul=2;
				nheroCostTear=0;//+random.nextInt(1);
				nttl=250;
				inDeltaExp=101;
				inDeltaPower=22;
				break;
			case 7:
				nname="Галлмау";
				npower=100;
				nimage=null;
				try {
					nimage = ImageIO.read(new File("data/image/hero/demon15.gif"));
				} catch (IOException e) {
				}
				nheroCostGold=40;
				nheroCostSoul=3;
				nheroCostTear=0;//+random.nextInt(1);
				nttl=120;
				inDeltaExp=50;
				inDeltaPower=21;
				break;
			case 8:
				nname="Чревоугодие";
				npower=300;
				nimage=null;
				try {
					nimage = ImageIO.read(new File("data/image/hero/demon6.gif"));
				} catch (IOException e) {
				}
				nheroCostGold=40;
				nheroCostSoul=30;
				nheroCostTear=1;//+random.nextInt(1);
				nttl=320;
				inDeltaExp=10;
				inDeltaPower=45;
				break;
				
			default:
				
				break;
			}
			
			npower=rndModif(npower, dispersion);
			nttl=rndModif(nttl, dispersion);
			inDeltaPower=rndModif(inDeltaPower, dispersion);
			
			nheroCostGold=(int)rndModif(nheroCostGold, dispersion);
			
			
			hero=new Hero(nname, npower, nexp, nttl, "2", 1, nimage, inDeltaExp, inDeltaPower);
			heroCostGold=nheroCostGold;
			heroCostSoul=nheroCostSoul;
			heroCostTear=nheroCostTear;
			
			
			hero.setBounds(10, 10, hero.getWidth(), hero.getHeight());
			add(hero);
			
			heroInf=new JLabel();
			heroInf.setSize(300, 100);
			
			String tmptext;
			tmptext="<html> <p align=center>"+hero.name+"</p>";
			tmptext+="<p><font color=black> Опыт на уровень " +inDeltaExp;
			tmptext+="<br> Мощь за уровень "+String.format("%.2g%n", inDeltaPower);
			//tmptext+="<p> Exp "+(int)hero.exp;
			tmptext+="<br> Мощь "+(int)hero.power;
			
			int min,sec;
			min=(int)(hero.ttl/60);
			sec= (int)(hero.ttl-min*60);
			
			tmptext+="<br>Время жизни "+min +":"+sec;
			
			heroInf.setText(tmptext);
			heroInf.setSize(new Dimension(440, 80));
			heroInf.setBounds(100, 1, heroInf.getWidth(), heroInf.getHeight());
			//heroInf.setBorder(BorderFactory.createLineBorder(Color.red));
			add(heroInf);
			
			heroBuy=new JButton();
			heroBuy.setText("Нанять");
			heroBuy.setSize(new Dimension(90, 30));
			heroBuy.setBounds(100, 85, heroBuy.getWidth(), heroBuy.getHeight());
			
			add(heroBuy);
			
			 //LHoH.gameScreen.heroStock.addHero(hero);
			
			heroBuy.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e) {
						
		    		  if (LHoH.gameScreen.player.takeResurs(heroCostGold, heroCostSoul, heroCostTear)){
		    			  LHoH.gameScreen.heroStock.addHero(hero);
		    			  
		    			  //LHoH.gameScreen.taverna.allScope.remove(this);
		    			  //LHoH.gameScreen.taverna.repaint();
		    			  
		    			  for (HeroForTrade heroForTrade : allScope) {
		    				  if(heroForTrade.hero==hero){
		    					  allScope.remove(heroForTrade);
		    				  }
		    			  }
		    			  
		    			  LHoH.gameScreen.taverna.checkEmptyHeroes();
		    		  }
		    		  
		    		  
		    		  
		    		  
		    	  }
		    	});
			

		}
		

		


			public void paintComponent(Graphics g) {
				setBackground(Color.white);
				g.setColor(Color.white);
				g.setColor(new Color(255,255,255,128));
				g.fillRect(0, 0,640 ,120);
				/*
				g.setFont(new Font("Arial", Font.BOLD, 16)); 
				
				int min,sec;
				min=(int)(hero.ttl/60);
				sec= (int)(hero.ttl-min*60);
				
				
					g.drawString(hero.name, 95, 20);
					
					String tmptext="<html>";
					tmptext+="123";
					
					g.setFont(new Font("Arial", Font.BOLD, 14)); 
					
					g.drawString("Время жизни "+min+":"+sec, 95, 40);
					g.drawString("Мощь "+Integer.toString((int)hero.power), 95, 60);
					g.drawString(tmptext, 95, 80);
		*/
				g.setColor(Color.black);
				g.setFont(new Font("Arial", Font.BOLD, 18));
				g.drawImage(image1, 200, 85, null);
				g.drawString(Integer.toString(heroCostGold), 231, 105);
				
				g.drawImage(image2, 281, 85, null);
				g.drawString(Integer.toString(heroCostSoul), 311, 105);
				
				g.drawImage(image3, 361, 85, null);
				g.drawString(Integer.toString(heroCostTear), 391, 105);
			}
			
	}
	static List<HeroForTrade> allScope = new ArrayList<HeroForTrade>();
	
	public Taverna() {
		
	setSize(650,400);
	setPreferredSize(new Dimension(650, 400));
	setLayout(new FlowLayout());
	//setBorder(BorderFactory.createLineBorder(Color.black));
	
	ttlUpdate_reload=10;
	
	updateHeroes();
	
	//Hero tmpH = new Hero("234", 100, 1, 180, "воин",2);
	//LHoH.gameScreen.heroStock.allScope.add(tmpH);
	
}
	void checkEmptyHeroes (){
	if (allScope.isEmpty()){
		updateHeroes();
	}
	}
	
	void updateHeroes(){
		//allScope.remove
		//allScope.add(new HeroForTrade());
		
	//	for (HeroForTrade heroForTrade : allScope){
	//	allScope.remove(heroForTrade);
		//}

		allScope.removeAll(allScope);
		
		allScope.add(new HeroForTrade());
		allScope.add(new HeroForTrade());
		allScope.add(new HeroForTrade());
		repaint();
	}
	void update (){
		ttlUpdate_now-=(double)1/60;
	}
	
	public void paintComponent(Graphics g) {
		removeAll();
		revalidate();
		for (HeroForTrade heroForTrade : allScope) add(heroForTrade);

	}
}
