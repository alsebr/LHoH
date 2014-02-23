package Hero;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import HeroAbilitisPackage.HeroAbility_CorpseEater;
import HeroAbilitisPackage.HeroAbility_Ghoul;
import LHoH.Hero;
import LHoH.HeroStat;
import LHoH.LHoH;

public class Hero_CorpseEater extends Hero {
	public Hero_CorpseEater() {
		super();
				
		String name="Голем плоти";
		double costGold=24;
		double costSoul=6;
		double costTear=0;
		double deltaExp=19;
		double strp=43;
		double vitp=142;
		double intp=34;
		double statPointPerLvl=16;
		double strToPowerRatio=1;
		double vitToTTLRatio=3;		
		String htmlTextHeroTip = "Архитектор плоти";
		htmlTextHeroTip += "<br> При входе в игру создает свое тело из трупов героев <b>~Int</b>";
		Image image=null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon26.gif"));
		} catch (IOException e) {
		}
		
		HeroStat heroStatRatio=new HeroStat(0.3, 0.3, 0.34); // summ ==1
		HeroStat heroStat=new HeroStat(strp, vitp, intp);
		
		//public void init(String name,  Image inImage, double inDeltaExp, double statPointPerLvl, HeroStat heroStat, HeroStat heroStatRatio,double strToPowerRatio,double vitToTTLRatio) {
		init(name, image, deltaExp, statPointPerLvl,heroStat,heroStatRatio,strToPowerRatio,vitToTTLRatio,htmlTextHeroTip,costGold,costSoul,costTear);
	}


	
	public void addHeroAbilities(){
		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_CorpseEater(getId()));
	}


}
