package Hero;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import HeroAbilitisPackage.HeroAbility_Ifreet;
import HeroAbilitisPackage.HeroAbility_LurkingEvil;
import LHoH.Hero;
import LHoH.HeroStat;
import LHoH.LHoH;

public class Hero_LurkingEvil extends Hero {
	public Hero_LurkingEvil() {
		super();
				
		String name="Затаившееся зло";
		double costGold=26;
		double costSoul=4;
		double costTear=0;
		double deltaExp=18;
		double strp=42;
		double vitp=120;
		double intp=1521;
		double statPointPerLvl=17;
		double strToPowerRatio=1;
		double vitToTTLRatio=1;		
		String htmlTextHeroTip = "Затаившееся зло.";
		htmlTextHeroTip += "<br> Зло ждет своего часа <b>~Int</b>";
		Image image=null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon23.gif"));
		} catch (IOException e) {
		}
		
		HeroStat heroStatRatio=new HeroStat(0.6, 0.2, 0.2); // summ ==1
		HeroStat heroStat=new HeroStat(strp, vitp, intp);
		
		//public void init(String name,  Image inImage, double inDeltaExp, double statPointPerLvl, HeroStat heroStat, HeroStat heroStatRatio,double strToPowerRatio,double vitToTTLRatio) {
		init(name, image, deltaExp, statPointPerLvl,heroStat,heroStatRatio,strToPowerRatio,vitToTTLRatio,htmlTextHeroTip,costGold,costSoul,costTear);
		
		//LHoH.gameScreen.heroAbilityStock.useAllAbilityByHero(heroId);
		//LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_Ifreet(getId()));
		
	}

	public void transform(){
		//Image tmpimage=null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon24.gif"));
		} catch (IOException e) {
		}
	}
	
	public void addHeroAbilities(){
		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_LurkingEvil(getId()));
	}



}
