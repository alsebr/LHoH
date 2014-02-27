package Hero;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import HeroAbilitisPackage.HeroAbility_Leech;
import LHoH.Hero;
import LHoH.HeroStat;
import LHoH.LHoH;

public class Hero_Abomination extends Hero {
	public Hero_Abomination() {
		super();
				
		String name="Абоминация";
		double costGold=12;
		double costSoul=2;
		double costTear=0;
		double deltaExp=19;
		double strp=137;
		double vitp=5;
		double intp=29;
		double statPointPerLvl=14;
		double strToPowerRatio=1;
		double vitToTTLRatio=2;		
		String htmlTextHeroTip = "Нестабильносьт";
		htmlTextHeroTip += "<br> Слишком мощная чтобы жить долго";
		Image image=null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon25.gif"));
		} catch (IOException e) {
		}
		
		HeroStat heroStatRatio=new HeroStat(0.6, 0.2, 0.2); // summ ==1
		HeroStat heroStat=new HeroStat(strp, vitp, intp);
		
		//public void init(String name,  Image inImage, double inDeltaExp, double statPointPerLvl, HeroStat heroStat, HeroStat heroStatRatio,double strToPowerRatio,double vitToTTLRatio) {
		init(name, image, deltaExp, statPointPerLvl,heroStat,heroStatRatio,strToPowerRatio,vitToTTLRatio,htmlTextHeroTip,costGold,costSoul,costTear);
		
		//LHoH.gameScreen.heroAbilityStock.useAllAbilityByHero(heroId);
		//LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_Ifreet(getId()));
		
	}


	
	public void addHeroAbilities(){
		
	}




}
