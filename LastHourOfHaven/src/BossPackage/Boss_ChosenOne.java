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

public class Boss_ChosenOne extends Boss {
	public Boss_ChosenOne(int lvlTower) {
		super();

		String nameBoss = "Избранный";
		double powerStart = 150;
		double inWR = 0.03;
		double inTTL = 50;
		String imageBossString = "bos7";
		String tipBoss = "The Chosen One";
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

	public void get25PrizeFirst() {
		LHoH.gameScreen.itemStock.allScope.add(new Item_Weapon1(0));

	}

	public void get25PrizeAlwayse() {


	}	
	
	public void get50PrizeFirst() {
		LHoH.gameScreen.itemStock.allScope.add(new Item_Casket(0));
	}

	public void get50PrizeAlwayse() {
	}
	
	public void get75PrizeFirst() {
		LHoH.gameScreen.itemStock.allScope.add(new Item_Weapon3(0));
	}

	public void get75PrizeAlwayse() {
	}
	
	public void get100PrizeFirst() {
	}

	public void get100PrizeAlwayse() {
	}

	public void useSpecialAbility(){
		
	}
	
}
