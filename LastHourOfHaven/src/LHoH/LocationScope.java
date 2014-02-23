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

import LocationPackage.Location_CrystalPalace;
import LocationPackage.Location_FalseProphet;
import LocationPackage.Location_ForgottenForest;
import LocationPackage.Location_SilenceDesert;
import LocationPackage.Location_WarriorOfTheLight;
import LocationPackage.Location_imp;

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
	
	
	inName="ERROR";
	inPower=65;
	inwinR=0.35;
	try {
		inEnemy = ImageIO.read(new File("data/image/loc/loc2.gif"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	int count=2;
	
	if (LHoH.gameScreen.player.getLocationNewTier()>60) count++;
	if (LHoH.gameScreen.player.getLocationNewTier()>120) count++;
	
	if (LHoH.gameScreen.player.getLocationNewTier()>400) count++;
	if (LHoH.gameScreen.player.getLocationNewTier()>400) count++;
	//if (LHoH.gameScreen.player.getHeroNewTier()>250) count++;
	
	
	
	count=random.nextInt(count);
	switch (count) {
	case 0:
		addLocationCavenImp();
		break;
	case 1:
		addLocationForhottenForest();
		break;

	case 2:
		addLocationSilence();
break;
	case 3:
		addLocation—rystalPalace();
		break;
	case 4:
		Location tmpL = new Location_WarriorOfTheLight();
		allScope.add(tmpL);
		
		
		break;
	case 5:
		tmpL = new Location_FalseProphet();
		allScope.add(tmpL);
		
		
		break;
	default:
		break;
	}
	

	
	
	//Location tmpL = new Location(inName,inPower,inwinR,inEnemy,inbonus50Gold,inbonus50Soul,inbonus50Tear,inbonusALLexp);
	//allScope.add(tmpL);
	//add(tmpL);
	
}

public int getNumberAliveLocation(){
	int count=0;
	for (Location location : allScope) {
		if (location.status==1) count++;

}
	return count;
}

void addLocationSilence(){
	
	Location tmpL = new Location_SilenceDesert();
	allScope.add(tmpL);	
}

void addLocationForhottenForest(){

	Location tmpL = new Location_ForgottenForest();
	allScope.add(tmpL);	
}


void addLocationCavenImp(){
		
	Location tmpL = new Location_imp();
	allScope.add(tmpL);
}

void addLocation—rystalPalace(){
	
	Location tmpL = new Location_CrystalPalace();
	allScope.add(tmpL);
}

public LocationScope() {
	//setSize(420,500);
	setPreferredSize(new Dimension(420, 1500));
	//setLayout(new GridBagLayout());
	setBorder(BorderFactory.createLineBorder(Color.black));
	
	
	//allScope.add(new Location());
	//add(new BattleZone());

	//addLocation();
	//addLocation();
	addLocationCavenImp();


	

}

void reDrow (Graphics g){
	removeAll();
	for (Location location : allScope) {
			if (location.status==1) add(location);

	}
	
	for (Location location : allScope) {
		if (location.status==2) add(location);

}
	for (Location location : allScope) {
		if (location.status==3) add(location);

}
}

void update (){
	for (Location location : allScope) {
location.update();

}
}

public Location getLocationByHeroId(int id){
	for (Location location: allScope) {
		if (location.hero1.getHeroId()==id) return location;
	}
	
	
	return null;
}


public void paintComponent(Graphics g) {
	
	System.out.println("repaint");
 
	//removeAll();
	Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    reDrow(g);
}



}
