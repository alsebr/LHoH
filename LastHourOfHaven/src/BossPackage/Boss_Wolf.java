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

public class Boss_Wolf extends Boss {
	public Boss_Wolf(int lvlTower) {
		super();

		String nameBoss = "Лютоволк";
		double powerStart = 100;
		double inWR = 0.03;
		double inTTL = 55;
		String imageBossString = "bos5";
		String tipBoss = "Лютоволк воет в ночи, пытаясь отогнать духов. Услышавший это замирает парализованный страхом";
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
		Hero tmphero=LHoH.gameScreen.heroStock.getRandomAliveHero();
		if (tmphero!=null){
			LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_HowlOfTheWolf(tmphero.getId(),-12));;
			LHoH.gameScreen.bottomInfo.chat.addTextChat("Раздается чудовищный вой Лютоволка,"+tmphero.getHeroName()+" замирает в ужасе");			
		}

	}	
	
	public void get50PrizeFirst() {

	}

	public void get50PrizeAlwayse() {
		Hero tmphero=LHoH.gameScreen.heroStock.getRandomAliveHero();
		if (tmphero!=null){
			LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_HowlOfTheWolf(tmphero.getId(),-24));;
			LHoH.gameScreen.bottomInfo.chat.addTextChat("Раздается чудовищный вой Лютоволка,"+tmphero.getHeroName()+" замирает в ужасе");			
		}
	}
	
	public void get75PrizeFirst() {

	}

	public void get75PrizeAlwayse() {
		Hero tmphero=LHoH.gameScreen.heroStock.getRandomAliveHero();
		if (tmphero!=null){
			LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_HowlOfTheWolf(tmphero.getId(),-36));;
			LHoH.gameScreen.bottomInfo.chat.addTextChat("Раздается чудовищный вой Лютоволка,"+tmphero.getHeroName()+" замирает в ужасе");			
		}
	}
	
	public void get100PrizeFirst() {
		LHoH.gameScreen.itemStock.allScope.add(new Item_PowerUp(1));
		LHoH.gameScreen.player.addLocationNewTier(100);
		LHoH.gameScreen.player.addHeroNewTier(100);
	}

	public void get100PrizeAlwayse() {
		Hero tmphero=LHoH.gameScreen.heroStock.getRandomAliveHero();
		if (tmphero!=null){
			LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_HowlOfTheWolf(tmphero.getId(),-70));;
			LHoH.gameScreen.bottomInfo.chat.addTextChat("Раздается чудовищный вой Лютоволка,"+tmphero.getHeroName()+" замирает в ужасе");			
		}
	}

	public void useSpecialAbility(){
		
	}
	
}
