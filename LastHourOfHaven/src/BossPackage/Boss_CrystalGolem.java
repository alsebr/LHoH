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

public class Boss_CrystalGolem extends Boss {
	public Boss_CrystalGolem(int lvlTower) {
		super();

		String nameBoss = "Хрустальный голем";
		double powerStart = 2500;
		double inWR = 0.03;
		double inTTL = 60;
		String imageBossString = "bos6";
		String tipBoss = "Слишком мощный чтобы жить долго";
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
		LHoH.gameScreen.itemStock.allScope.add(new Item_Casket(1));

	}

	public void get25PrizeAlwayse() {


	}	
	
	public void get50PrizeFirst() {
		LHoH.gameScreen.itemStock.allScope.add(new Item_Casket(1));
	}

	public void get50PrizeAlwayse() {
	}
	
	public void get75PrizeFirst() {

	}

	public void get75PrizeAlwayse() {
	}
	
	public void get100PrizeFirst() {
		LHoH.gameScreen.itemStock.allScope.add(new Item_Casket(1));
	}

	public void get100PrizeAlwayse() {
	}

	public void useSpecialAbility(){
		addPowerCurrent((double)getPowerCurrent()*-0.001*(getwR()*10)*(getwR()*10)+0.001);
	}
	
}
