package LHoH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.Visibility;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class HeroViewScreen extends JFrame implements ActionListener{
	HeroViewScreen() {
		setSize(350, 460);
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
		labelHeroTip.setBounds(10, 245, 300, 60);
		add(labelHeroTip);
		
		labelHeroStatusTip.setBorder(BorderFactory.createLineBorder(Color.black));
		labelHeroStatusTip.setBounds(10, 315, 300, 150);
		
		labelHeroStatusTip.setVerticalAlignment(JLabel.TOP);
		add(labelHeroStatusTip);

		
		
		
		
		    standartButton = new JRadioButton("auto");
		    standartButton.setMnemonic(KeyEvent.VK_C);
		    standartButton.setActionCommand("auto");
		    standartButton.setSelected(true);
			add(standartButton);
		  
			strButton = new JRadioButton("str");  
			strButton.setMnemonic(KeyEvent.VK_B);
			strButton.setActionCommand("str");
			add(strButton);
		  
		  
		    vitButton = new JRadioButton("vit");
		    vitButton.setMnemonic(KeyEvent.VK_D);
		    vitButton.setActionCommand("vit");
			add(vitButton);

		    intButton = new JRadioButton("int");
		    intButton.setMnemonic(KeyEvent.VK_E);
		    intButton.setActionCommand("int");
			add(intButton);
			
			standartButton.setBounds(250, 75-40, 200, 50);
			strButton.setBounds(250, 105-40, 200, 50);  
			vitButton.setBounds(250, 135-40, 200, 50);
			intButton.setBounds(250, 165-40, 200, 50);

		    //Group the radio buttons.
		    ButtonGroup group = new ButtonGroup();
		    group.add(standartButton);
		    group.add(strButton);
		    group.add(vitButton);
		    group.add(intButton);
		    
		    

		    //Register a listener for the radio buttons.
		    strButton.addActionListener((ActionListener) this);
		    vitButton.addActionListener((ActionListener) this);
		    standartButton.addActionListener((ActionListener) this);
		    intButton.addActionListener((ActionListener) this);
		    
		
		
		
		revalidate();
	}
	JRadioButton strButton;
	JRadioButton standartButton;
	JRadioButton vitButton;
	JRadioButton intButton;
	
	public void actionPerformed(ActionEvent e) {

		int tmppref=0;
		
		if (e.getActionCommand()=="str") tmppref=1;
		if (e.getActionCommand()=="vit") tmppref=2;
		if (e.getActionCommand()=="int") tmppref=3;
		
		
		hero.setHeroStatPlayerPref(tmppref);
	}

	void activate(int heroId) {
		toFront();
		setVisible(true);

		
		hero=LHoH.gameScreen.heroStock.getHeroById(heroId);
		
		

		heroName = hero.getHeroName();
		imageHero = hero.image;

		labelHeroName.setText(heroName);
		labelHeroIco.setIcon(new ImageIcon(imageHero));

		switch (hero.getHeroStatPlayerPref()) {
		case 0:
		    standartButton.setSelected(true);
			break;
		case 1:
		    strButton.setSelected(true);
			break;
		case 2:
		    vitButton.setSelected(true);
			break;
		case 3:
		    intButton.setSelected(true);
			break;

		default:
			break;
		}

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
				htmltext += "<br>Str: " + String.format("%.3g%n",heroStat.strp)+" ("+String.format("%.2g%n", hero.getHeroStatPerLvlFinal().strp)+" for lvl)";
				htmltext += "<br>Vit: " + String.format("%.3g%n",heroStat.vitp)+" ("+String.format("%.2g%n", hero.getHeroStatPerLvlFinal().vitp)+" for lvl)";
				htmltext += "<br>Int: " + String.format("%.3g%n",heroStat.intp)+" ("+String.format("%.2g%n", hero.getHeroStatPerLvlFinal().intp)+" for lvl)";
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
				
				htmltext2 = "<html>Статус:<p><font size=-2>";
				htmltext2+=LHoH.gameScreen.heroAbilityStock.getAllAbilityTipByHero(hero.getId());
				//htmltext2 += "<p><font size=-2>"+hero.getStatusTip()+"</font></p>";
				htmltext2 += "</font></p>";
				labelHeroStatusTip.setText(htmltext2);

			}
		}
	}

}
