package Hero;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import HeroAbilitisPackage.HeroAbility_Leech;
import LHoH.Hero;
import LHoH.HeroStat;
import LHoH.LHoH;

public class Hero_Leech extends Hero {
	public Hero_Leech() {
		super();
				
		String name="Пиявка";
		double costGold=23;
		double costSoul=4;
		double costTear=0;
		double deltaExp=19;
		double strp=42;
		double vitp=120;
		double intp=31;
		double statPointPerLvl=11;
		double strToPowerRatio=1;
		double vitToTTLRatio=1;		
		String htmlTextHeroTip = "Вытягивание силы.";
		htmlTextHeroTip += "<br> Каждую секунду пиявка вытягивает силы из атакуемого Портала <b>Int</b>";
		Image image=null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon22.gif"));
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
		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_Leech(getId()));
	}




}
