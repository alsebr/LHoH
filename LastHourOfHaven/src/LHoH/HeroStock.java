package LHoH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.text.StyledEditorKit.ForegroundAction;



public class HeroStock extends JPanel{
	static List<Hero> allScope = new ArrayList<Hero>();
	BattleZone heroZone;
	HeroStock(){
	
	//setBounds(5, 5, 25, 25);
	setSize(260,870);
	setPreferredSize(new Dimension(260, 870));
	setLayout(new GridBagLayout());
	setBorder(BorderFactory.createLineBorder(Color.red));
	
	//Hero tmpH = new Hero("Нечистивый", 10, 1, 60, "воин",1);
	//allScope.add(tmpH);
	

	
	//add(tmpH);
	heroZone = new BattleZone();
	heroZone.setLayout(new FlowLayout(FlowLayout.CENTER,1,1));
	add(heroZone);
	heroZone.zoneId=1;
	heroZone.setPreferredSize(new Dimension(250, 860));
	
	
	
	
	
	
	
}

void reDrow (Graphics g){

	removeAll();
	for (Hero hero : allScope) {
		if (hero.getZone()==1)	add(hero);
//		hero.reDrow(g);
	}
}

public void paintComponent(Graphics g) {
	
	System.out.println("repaint");
 
	//removeAll();
	Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    //reDrow(g);
}

void addHero(Hero hero){
	allScope.add(hero);
}

Hero getHeroById(int id){
	for (Hero hero : allScope) {
		if (hero.getId()==id) return hero;
	}
	
	
	return null;
}

Hero getRandomDeadHero(){
	for (Hero hero : allScope) {
		if (hero.isDead()) return hero;
	}
	
	
	return null;
}

Hero getRandomAliveHero(){
	for (Hero hero : allScope) {
		if (hero.status==1) return hero;
	}
	
	
	return null;
}

void removeHeroById(int id){
	for (Hero hero : allScope) {
		if (hero.getId()==id) {
			//allScope.remove(hero);
			hero.setRemoved();
		}
	}
}

void update (){
	Hero tmphero=null;
	for (Hero hero : allScope) {
		if (hero.isRemoved()) {
			
			tmphero=hero;
			
		}
	}
	
	if (tmphero!=null) allScope.remove(tmphero);
	
	for (Hero hero : allScope) {
		if (!hero.isRemoved())hero.Update();
		//hero.addPower(1);
//		add(hero);
//		hero.reDrow(g);
		//hero.addPower(5);
	}
}
}
