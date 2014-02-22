package Hero;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import LHoH.Hero;
import LHoH.HeroAbility_Imp;
import LHoH.HeroStat;
import LHoH.LHoH;

public class Hero_Imp extends Hero {
	public Hero_Imp() {

		super();
		
		String name="Имп";
		double costGold=7;
		double costSoul=0;
		double costTear=0;
		double deltaExp=12;
		double strp=34;
		double vitp=60;
		double intp=25;
		double statPointPerLvl=4;
		double strToPowerRatio=1;
		double vitToTTLRatio=1;		
		String htmlTextHeroTip = "Бесовская хитрость.";
		htmlTextHeroTip += "<br> Импы захватывают пещеры более эффективно <b>~Int</b>";
		
		Image image=null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon9.gif"));
		} catch (IOException e) {
		}
		
		HeroStat heroStatRatio=new HeroStat(0.6, 0.2, 0.2); // summ ==1
		HeroStat heroStat=new HeroStat(strp, vitp, intp);
		
		//public void init(String name,  Image inImage, double inDeltaExp, double statPointPerLvl, HeroStat heroStat, HeroStat heroStatRatio,double strToPowerRatio,double vitToTTLRatio) {
		init(name, image, deltaExp, statPointPerLvl,heroStat,heroStatRatio,strToPowerRatio,vitToTTLRatio,htmlTextHeroTip,costGold,costSoul,costTear);
		
		//LHoH.gameScreen.heroAbilityStock.useAllAbilityByHero(heroId);
		

	}

	public void addHeroAbilities(){
		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_Imp(getId()));
		
	}
	




}
