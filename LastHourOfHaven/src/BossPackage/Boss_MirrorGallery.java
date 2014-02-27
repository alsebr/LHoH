package BossPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import LHoH.Boss;
import LHoH.Hero;
import LHoH.LHoH;
import HeroAbilitisPackage.HeroAbility_HowlOfTheWolf;
import ItemPackage.Item_Casket;
import ItemPackage.Item_Key1;
import ItemPackage.Item_PowerUp;
import ItemPackage.Item_Weapon1;
import ItemPackage.Item_Weapon3;

public class Boss_MirrorGallery extends Boss {
	public Boss_MirrorGallery(int lvlTower) {
		super();

		String nameBoss = "Галерея кривых зеркал";
		double powerStart = 1000;
		double inWR = 0.03;
		double inTTL = 90;
		String imageBossString = "bos8";
		String tipBoss = "Миллионы отражений улыбаются, смотря на вас";
		Image imageBoss = null;

		try {
			imageBoss = ImageIO.read(new File("data/image/bos/"
					+ imageBossString + ".gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		init(powerStart, imageBoss, nameBoss, tipBoss, inWR, inTTL, lvlTower);

		
		
		
		// TODO Auto-generated constructor stub
	}

	double mirrorPower=0;
	
	boolean flagMirrorActivated=false;
	boolean flagMirrorGetMirror=false;
	
	public void useSpecialAbility_afterBonusHeroPower(){
		if (!flagMirrorGetMirror){
			mirrorPower=getHeroPower();
			flagMirrorGetMirror=true;
		}
	}
	
	public void useSpecialAbility(){
		if ((!flagMirrorActivated)&&flagMirrorGetMirror){
			addPowerCurrent(mirrorPower);
			flagMirrorActivated=true;
		}
	}
	
	public void get25PrizeFirst() {
		LHoH.gameScreen.itemStock.allScope.add(new Item_Weapon1(0));

	}

	public void get25PrizeAlwayse() {


	}	
	
	public void get50PrizeFirst() {
		
	}

	public void get50PrizeAlwayse() {
	}
	
	public void get75PrizeFirst() {
		
	}

	public void get75PrizeAlwayse() {
	}
	
	public void get100PrizeFirst() {
	}

	public void get100PrizeAlwayse() {
	}


	
}
