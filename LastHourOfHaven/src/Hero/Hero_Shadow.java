package Hero;


import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import HeroAbilitisPackage.HeroAbility_FearOfTheDark;
import HeroAbilitisPackage.HeroAbility_Ifreet;
import LHoH.HeroStat;
import LHoH.Hero;
import LHoH.HeroStat;
import LHoH.LHoH;

public class Hero_Shadow extends Hero {
	public Hero_Shadow() {

		super();
		
		String name="Тень";
		double costGold=0;
		double costSoul=18;
		double costTear=0;
		double deltaExp=23;
		double strp=6;
		double vitp=164;
		double intp=42;
		double statPointPerLvl=24;
		double strToPowerRatio=1;
		double vitToTTLRatio=5;		
		String htmlTextHeroTip = "Страх темноты";
		htmlTextHeroTip += "<br> Мощь тени увеличивается в % от ее int";
		
		Image image=null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon31.gif"));
		} catch (IOException e) {
		}
		
		HeroStat heroStatRatio=new HeroStat(0.9, 0.05, 0.05); // summ ==1
		HeroStat heroStat=new HeroStat(strp, vitp, intp);
		
		//public void init(String name,  Image inImage, double inDeltaExp, double statPointPerLvl, HeroStat heroStat, HeroStat heroStatRatio,double strToPowerRatio,double vitToTTLRatio) {
		init(name, image, deltaExp, statPointPerLvl,heroStat,heroStatRatio,strToPowerRatio,vitToTTLRatio,htmlTextHeroTip,costGold,costSoul,costTear);
		
		//LHoH.gameScreen.heroAbilityStock.useAllAbilityByHero(heroId);
		

	}

	public void addHeroAbilities(){
		
		
			LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_FearOfTheDark(getId()));
		
	}
	




}
