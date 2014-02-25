package BossPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import LHoH.Boss;
import LHoH.LHoH;
import ItemPackage.Item_Casket;
import ItemPackage.Item_Key1;
import ItemPackage.Item_PowerUp;

public class Boss_SwampSpirit extends Boss {
	public Boss_SwampSpirit(int lvlTower) {
		super();

		String nameBoss = "Ѕолотный дух";
		double powerStart = 80;
		double inWR = 0.03;
		double inTTL = 90;
		String imageBossString = "bos3";
		String tipBoss = "»ногда он ловит глупых фей, которых приманивают болотные огоньки.";
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
		LHoH.gameScreen.itemStock.allScope.add(new Item_Casket());

	}

	public void get25PrizeAlwayse() {

	}	
	
	public void get50PrizeFirst() {

	}

	public void get50PrizeAlwayse() {
		LHoH.gameScreen.itemStock.allScope.add(new Item_Key1());
	}
	
	public void get75PrizeFirst() {

	}

	public void get75PrizeAlwayse() {

	}
	
	public void get100PrizeFirst() {
		LHoH.gameScreen.itemStock.allScope.add(new Item_PowerUp(1));
		LHoH.gameScreen.player.addLocationNewTier(100);
		LHoH.gameScreen.player.addHeroNewTier(100);
	}

	public void get100PrizeAlwayse() {

	}

	
	
}
