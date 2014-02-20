package LHoH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.beans.Visibility;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeroViewScreen extends JFrame {
	HeroViewScreen() {
		setSize(250, 390);
		// setPreferredSize(new Dimension(50, 104));
		setLayout(null);
		setAlwaysOnTop(true);
		setResizable(false);
		// setUndecorated(true);
		setBackground(Color.white);
		labelHeroName.setBorder(BorderFactory.createLineBorder(Color.black));
		labelHeroName.setBounds(100, 5, 120, 30);
		add(labelHeroName);

		labelHeroIco.setBorder(BorderFactory.createLineBorder(Color.black));
		labelHeroIco.setBounds(10, 10, 80, 105);
		add(labelHeroIco);

		labelHeroStat.setBorder(BorderFactory.createLineBorder(Color.black));
		labelHeroStat.setBounds(100, 30, 120, 200);
		add(labelHeroStat);
		
		labelHeroTip.setBorder(BorderFactory.createLineBorder(Color.black));
		labelHeroTip.setBounds(10, 245, 200, 60);
		add(labelHeroTip);
		
		labelHeroStatusTip.setBorder(BorderFactory.createLineBorder(Color.black));
		labelHeroStatusTip.setBounds(10, 315, 200, 50);
		add(labelHeroStatusTip);

		revalidate();
	}

	void activate(int heroId) {
		toFront();
		setVisible(true);

		
		hero=LHoH.gameScreen.heroStock.getHeroById(heroId);
		
		

		heroName = hero.getHeroName();
		imageHero = hero.image;

		labelHeroName.setText(heroName);
		labelHeroIco.setIcon(new ImageIcon(imageHero));


	}

	String heroName;
	Hero hero;
	JLabel labelHeroName = new JLabel();
	JLabel labelHeroIco = new JLabel();
	JLabel labelHeroStat = new JLabel();
	JLabel labelHeroStatusTip = new JLabel();
	JLabel labelHeroTip = new JLabel();
	Image imageHero;

	void update() {
		if (isShowing()) {

			if (hero != null) {
				String htmltext;
				HeroStat heroStat = hero.getHeroStat();

				htmltext = "<html>";
				htmltext += "<br>Lvl: " + hero.lvl;
				htmltext += "<br>Str: " + heroStat.strp;
				htmltext += "<br>Vit: " + heroStat.vitp;
				htmltext += "<br>Int: " + heroStat.intp;
				htmltext += "<br>";
				htmltext += "<br>Power: " + (int) hero.getPurePower() +"+"+(int) hero.getBonusPower();
				htmltext += "<br>Time: " + FrameWorkLHoH.ttlToTime(hero.getLeftTime())+"/"+FrameWorkLHoH.ttlToTime(hero.getLifeTimeTotal());
				htmltext += "<br>Exp: " + (int) hero.exp + "/"
						+ (int) hero.expNeedExp;
				htmltext += "<br>";
				htmltext += "<br>ExpLvl: " + hero.deltaExp;
				htmltext += "<br>Power for lvl: " + hero.deltaPower;

				labelHeroStat.setText(htmltext);

				String htmltext1;
				
				htmltext1 = "<html>Особенности героя:";
				htmltext1 += "<p><font size=-2>"+hero.getHeroTip()+"</font></p>";
				
				labelHeroTip.setText(htmltext1);

				
				String htmltext2;
				
				htmltext2 = "<html>Статус:";
				htmltext2 += "<p><font size=-2>"+hero.getStatusTip()+"</font></p>";
				
				labelHeroStatusTip.setText(htmltext2);

			}
		}
	}

}
