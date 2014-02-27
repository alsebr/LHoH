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
import ItemPackage.Item_Key2;
import ItemPackage.Item_PowerUp;
import ItemPackage.Item_Weapon1;

public class Boss_Tyrael extends Boss {
	public Boss_Tyrael(int lvlTower) {
		super();

		String nameBoss = "������� � �������� ������� �����";
		double powerStart = 500;
		double inWR = 0.03;
		double inTTL = 30;
		String imageBossString = "bos1";
		String tipBoss = "��� ���� ������ � ������ ��������, ����� � ���� ��� ������������ �������";
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
		LHoH.gameScreen.itemStock.allScope.add(new Item_Key2());

	}	
	
	public void get50PrizeFirst() {

	}

	public void get50PrizeAlwayse() {

	}
	
	public void get75PrizeFirst() {
		LHoH.gameScreen.itemStock.allScope.add(new Item_Casket(1));
	}

	public void get75PrizeAlwayse() {
		
	}
	
	public void get100PrizeFirst() {
		LHoH.gameScreen.itemStock.allScope.add(new Item_Weapon1(3));
	}

	public void get100PrizeAlwayse() {
		LHoH.gameScreen.itemStock.allScope.add(new Item_Casket(1));
	}

	public void useSpecialAbility(){
		addPowerCurrent((double)12/60);
	}
	
}
