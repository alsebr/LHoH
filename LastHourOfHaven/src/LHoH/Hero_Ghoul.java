package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hero_Ghoul extends Hero {
	public Hero_Ghoul() {
		super();
				
		String name="Гуль";
		double costGold=14;
		double costSoul=3;
		double costTear=0;
		double deltaExp=5;
		double strp=26;
		double vitp=86;
		double intp=21;
		double statPointPerLvl=11;
		double strToPowerRatio=1;
		double vitToTTLRatio=1;		
		String htmlTextHeroTip = "Пожирание трупов.";
		htmlTextHeroTip += "<br> При повышении уровня Гуль поедает случайный труп, увеличивая свою мощь <b>~Int</b>";
		Image image=null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon21.gif"));
		} catch (IOException e) {
		}
		
		HeroStat heroStatRatio=new HeroStat(0.2, 0.2, 0.6); // summ ==1
		HeroStat heroStat=new HeroStat(strp, vitp, intp);
		
		//public void init(String name,  Image inImage, double inDeltaExp, double statPointPerLvl, HeroStat heroStat, HeroStat heroStatRatio,double strToPowerRatio,double vitToTTLRatio) {
		init(name, image, deltaExp, statPointPerLvl,heroStat,heroStatRatio,strToPowerRatio,vitToTTLRatio,htmlTextHeroTip,costGold,costSoul,costTear);
	}


	
	public void addHeroAbilities(){
		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_Ghoul(getId()));
	}


}
