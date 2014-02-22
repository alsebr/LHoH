package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hero_Mimic extends Hero {
	public Hero_Mimic() {

		super();
		
		String name="Малый демон";
		double costGold=16;
		double costSoul=3;
		double costTear=0;
		double deltaExp=10;
		double strp=23;
		double vitp=72;
		double intp=9;
		double statPointPerLvl=9;
		double strToPowerRatio=1;
		double vitToTTLRatio=1;		
		String htmlTextHeroTip = "Мимикрия";
		htmlTextHeroTip += "<br> Мимик может принимать облик других предметов";
		
		Image image=null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon20.gif"));
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
