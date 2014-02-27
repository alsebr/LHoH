package Hero;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import LHoH.Hero;
import LHoH.HeroStat;

public class Hero_fly extends Hero {
	public Hero_fly() {

		super();
		
		String name="Муха";
		double costGold=16;
		double costSoul=3;
		double costTear=0;
		double deltaExp=5;
		double strp=23;
		double vitp=72;
		double intp=9;
		double statPointPerLvl=39;
		double strToPowerRatio=1;
		double vitToTTLRatio=2;		
		String htmlTextHeroTip = "Миньон";
		htmlTextHeroTip += "<br> Призвана Повелителем";
		
		Image image=null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon10.gif"));
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
