package LHoH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LocationScope extends JPanel{
	
	static List<Location> allScope = new ArrayList<Location>();
	
	

void addLocation (){
	
	String inName;
	int inPower;
	double inwinR;
	Image inEnemy=null;;
	double inbonus50Gold,inbonus50Soul,inbonus50Tear,inbonusALLexp;
	//Location(String inName,int inPower, int inwinR, Image inEnemy,double inbonus50Gold,double inbonus50Soul, double inbonus50Tear, double inbonusALLexp){
	
	Random random = new Random();
	int count=random.nextInt(4);
	
	inName="ERROR";
	inPower=65;
	inwinR=0.35;
	try {
		inEnemy = ImageIO.read(new File("data/image/loc/loc2.gif"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	inbonus50Gold=(double)0.5/60;
	inbonus50Soul=(double)0.2/60;
	inbonus50Tear=0;
	inbonusALLexp=(double)1/60;
	
	switch (count) {
	case 0:
		inName="Пещера бесов";
		inPower=32;
		inwinR=0.35;
		try {
			inEnemy = ImageIO.read(new File("data/image/loc/loc2.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		inbonus50Gold=(double)0.5/60;
		inbonus50Soul=(double)0.2/60;
		inbonus50Tear=0;
		inbonusALLexp=(double)0.8/60;
		break;
	case 1:
		inName="Проповедь Лжепророка";
		inPower=196;
		inwinR=0.15;
		try {
			inEnemy = ImageIO.read(new File("data/image/loc/loc3.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		inbonus50Gold=(double)1/60;
		inbonus50Soul=(double)2/120;
		inbonus50Tear=0;
		inbonusALLexp=(double)15/60;
		break;
		
	case 2:
		inName="Обелиск времени";
		inPower=125;
		inwinR=0.75;
		try {
			inEnemy = ImageIO.read(new File("data/image/loc/loc1.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		inbonus50Gold=(double)0.5/60;
		inbonus50Soul=(double)1/220;
		inbonus50Tear=0;
		inbonusALLexp=(double)2/60;
		break;

	case 3:
		inName="Люцифер";
		inPower=175;
		inwinR=0.5;
		try {
			inEnemy = ImageIO.read(new File("data/image/loc/loc4.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		inbonus50Gold=(double)0/60;
		inbonus50Soul=(double)0/220;
		inbonus50Tear=(double)0.1/60;
		inbonusALLexp=(double)3/60;
		break;

		
	default:
		break;
	}
	
	
	
	
	Location tmpL = new Location(inName,inPower,inwinR,inEnemy,inbonus50Gold,inbonus50Soul,inbonus50Tear,inbonusALLexp);
	allScope.add(tmpL);
	//add(tmpL);
	
}
public LocationScope() {
	//setSize(420,500);
	setPreferredSize(new Dimension(420, 1500));
	//setLayout(new GridBagLayout());
	setBorder(BorderFactory.createLineBorder(Color.black));
	
	
	//allScope.add(new Location());
	//add(new BattleZone());

	addLocation();
	addLocation();
	


	

}

void reDrow (Graphics g){
	removeAll();
	for (Location location : allScope) {
			if (location.status==1) add(location);

	}
	
	for (Location location : allScope) {
		if (location.status==2) add(location);

}
}

void update (){
	for (Location location : allScope) {
location.update();

}
}

public void paintComponent(Graphics g) {
	
	System.out.println("repaint");
 
	//removeAll();
	Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    reDrow(g);
}



}
