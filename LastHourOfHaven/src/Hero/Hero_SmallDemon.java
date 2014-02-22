package Hero;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import LHoH.Hero;
import LHoH.HeroStat;

public class Hero_SmallDemon extends Hero {
	public Hero_SmallDemon() {

		super();
		
		String name="Малый демон";
		double costGold=5;
		double costSoul=1;
		double costTear=0;
		double deltaExp=9;
		double strp=24;
		double vitp=71;
		double intp=23;
		double statPointPerLvl=6;
		double strToPowerRatio=1;
		double vitToTTLRatio=1;		
		String htmlTextHeroTip = "Демоническая кровь.";
		htmlTextHeroTip += "<br> ----";
		
		Image image=null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon5.gif"));
		} catch (IOException e) {
		}
		
		HeroStat heroStatRatio=new HeroStat(0.33, 0.34, 0.33); // summ ==1
		HeroStat heroStat=new HeroStat(strp, vitp, intp);
		
		//public void init(String name,  Image inImage, double inDeltaExp, double statPointPerLvl, HeroStat heroStat, HeroStat heroStatRatio,double strToPowerRatio,double vitToTTLRatio) {
		init(name, image, deltaExp, statPointPerLvl,heroStat,heroStatRatio,strToPowerRatio,vitToTTLRatio,htmlTextHeroTip,costGold,costSoul,costTear);
		
		//LHoH.gameScreen.heroAbilityStock.useAllAbilityByHero(heroId);
		

	}

	public void addHeroAbilities(){
		
		
	}
	




}
