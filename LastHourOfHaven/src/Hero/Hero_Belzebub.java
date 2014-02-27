package Hero;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import LHoH.Hero;
import LHoH.HeroStat;
import LHoH.LHoH;

public class Hero_Belzebub extends Hero {
	public Hero_Belzebub() {

		super();
		
		String name="Бельзебуб";
		double costGold=40;
		double costSoul=23;
		double costTear=3;
		double deltaExp=25;
		double strp=129;
		double vitp=235;
		double intp=34;
		double statPointPerLvl=31;
		double strToPowerRatio=1;
		double vitToTTLRatio=2;		
		String htmlTextHeroTip = "Повелитель мух";
		htmlTextHeroTip += "<br> Призывает мух";
		
		Image image=null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon29.gif"));
		} catch (IOException e) {
		}
		
		HeroStat heroStatRatio=new HeroStat(0.33, 0.34, 0.33); // summ ==1
		HeroStat heroStat=new HeroStat(strp, vitp, intp);
		
		//public void init(String name,  Image inImage, double inDeltaExp, double statPointPerLvl, HeroStat heroStat, HeroStat heroStatRatio,double strToPowerRatio,double vitToTTLRatio) {
		init(name, image, deltaExp, statPointPerLvl,heroStat,heroStatRatio,strToPowerRatio,vitToTTLRatio,htmlTextHeroTip,costGold,costSoul,costTear);
		
		//LHoH.gameScreen.heroAbilityStock.useAllAbilityByHero(heroId);
		
		

	}

	public void addHeroAbilities(){
		
		LHoH.gameScreen.heroStock.addHero(new Hero_fly());
		LHoH.gameScreen.heroStock.addHero(new Hero_fly());
	}
	




}
