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

import Hero.Hero_Ghoul;
import Hero.Hero_Ifreet;
import Hero.Hero_Imp;
import Hero.Hero_Leech;
import Hero.Hero_Pupetter;
import Hero.Hero_SmallDemon;
import Hero.Hero_SmallShadow;

public class Taverna extends JPanel{
	
	
	double ttlUpdate_reload=60;
	double ttlUpdate_now=ttlUpdate_reload;
	private boolean flagToUpdateHeroes;
	
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
			
			
			
			LHoH.gameScreen.player.getHeroNewTier();
			
			
			int count=2;
			
			if (LHoH.gameScreen.player.getHeroNewTier()>10) count++;
			if (LHoH.gameScreen.player.getHeroNewTier()>60) count++;
			if (LHoH.gameScreen.player.getHeroNewTier()>90) count++;
			if (LHoH.gameScreen.player.getHeroNewTier()>10000) count++;
			if (LHoH.gameScreen.player.getHeroNewTier()>10100) count++;
			//if (LHoH.gameScreen.player.getHeroNewTier()>250) count++;
			
			
			
			count=random.nextInt(count);
			
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
			
			//hero=new Hero_Ifreet();
			
			//hero.init(nname, npower, nexp, nttl, "2", 1, nimage, inDeltaExp, inDeltaPower);
			//count=0;
			switch (count) {
			case 0:
				
				nheroCostGold=1;
				nheroCostSoul=0;//+random.nextInt(3);
				nheroCostTear=0;//+random.nextInt(1);
				
				hero=new Hero_Imp();
				break;
			case 1:
				hero=new Hero_SmallDemon();
				break;
				
			case 2:
				hero=new Hero_SmallShadow();
				break;

			

			case 3:
				
				hero=new Hero_Ghoul();
				break;
			case 4:
				
				hero=new Hero_Leech();
				break;
			case 5:
				hero=new Hero_Ifreet();
				break;
			case 6:
				hero=new Hero_Pupetter();
				break;
				
			case 61:
				nname="�����������";
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
				nname="�������";
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
				nname="�����������";
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
			
			
			
			heroCostGold=(int)hero.getCostGold();
			heroCostSoul=(int)hero.getCostSoul();
			heroCostTear=(int)hero.getCostTear();
			inDeltaExp= (int)hero.deltaExp;
			
			double heroTtl=(int)hero.getLeftTime();
			
			hero.setBounds(10, 10, hero.getWidth(), hero.getHeight());
			add(hero);
			
			heroInf=new JLabel();
			heroInf.setSize(300, 100);
			
			String tmptext;
			tmptext="<html> <p align=center>"+hero.name+"</p>";
			tmptext+="<p><font color=black> ���� �� ������� " +inDeltaExp;

			tmptext+="<br> ���� "+(int)hero.getPower();
			
		
			tmptext+="<br>����� ����� "+FrameWorkLHoH.ttlToTime(heroTtl);
			
			heroInf.setText(tmptext);
			heroInf.setSize(new Dimension(440, 80));
			heroInf.setBounds(100, 1, heroInf.getWidth(), heroInf.getHeight());
			//heroInf.setBorder(BorderFactory.createLineBorder(Color.red));
			add(heroInf);
			
			heroBuy=new JButton();
			heroBuy.setText("������");
			heroBuy.setSize(new Dimension(90, 30));
			heroBuy.setBounds(100, 85, heroBuy.getWidth(), heroBuy.getHeight());
			
			add(heroBuy);
			
			 //LHoH.gameScreen.heroStock.addHero(hero);
			
			heroBuy.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e) {
						
		    		  if (LHoH.gameScreen.player.takeResurs(heroCostGold, heroCostSoul, heroCostTear)){
		    			  
		    			  hero.addHeroAbilities();
		    			  LHoH.gameScreen.heroStock.addHero(hero);
		    			  
		    			  //LHoH.gameScreen.taverna.allScope.remove(this);
		    			  //LHoH.gameScreen.taverna.repaint();
		    			  
		    			  for (HeroForTrade heroForTrade : allScope) {
		    				  if(heroForTrade.hero==hero){
		    					  allScope.remove(heroForTrade);
		    				  }
		    			  }
		    			  
		    			  //LHoH.gameScreen.taverna.checkEmptyHeroes();
		    			  //LHoH.gameScreen.taverna.updateHeroes();
		    			 // LHoH.gameScreen.taverna.updateHeroes();
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
					
					g.drawString("����� ����� "+min+":"+sec, 95, 40);
					g.drawString("���� "+Integer.toString((int)hero.power), 95, 60);
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
	
		// Hero tmpH = new Hero("234", 100, 1, 180, "����",2);
	//LHoH.gameScreen.heroStock.allScope.add(tmpH);
	
}
	void checkEmptyHeroes (){
	if (allScope.isEmpty()){
		updateHeroes();
	}
	}
	
	void updateHeroes(){

		allScope.removeAll(allScope);
		
		allScope.add(new HeroForTrade());
		allScope.add(new HeroForTrade());
		allScope.add(new HeroForTrade());
		repaint();
	}
	void update (){
		
		if (allScope.size()<3) setFlagToUpdateHeroes(true); 
			if (isFlagToUpdateHeroes())  {
				setFlagToUpdateHeroes(false);
				updateHeroes();
			}
			
		ttlUpdate_now-=(double)1/60;
	}
	
	public void paintComponent(Graphics g) {
		removeAll();
		revalidate();
		for (HeroForTrade heroForTrade : allScope) add(heroForTrade);

	}
	public boolean isFlagToUpdateHeroes() {
		return flagToUpdateHeroes;
	}
	public void setFlagToUpdateHeroes(boolean flagToUpdateHeroes) {
		this.flagToUpdateHeroes = flagToUpdateHeroes;
	}
}
