package Hero;


import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import LHoH.HeroStat;
import LHoH.Hero;
import LHoH.HeroStat;

public class Hero_SmallShadow extends Hero {
	public Hero_SmallShadow() {

		super();
		
		String name="����� ����";
		double costGold=0;
		double costSoul=2;
		double costTear=0;
		double deltaExp=9;
		double strp=3;
		double vitp=82;
		double intp=21;
		double statPointPerLvl=12;
		double strToPowerRatio=1;
		double vitToTTLRatio=3;		
		String htmlTextHeroTip = "����.";
		htmlTextHeroTip += "<br> ���� ���� ������ ����� ������";
		
		Image image=null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon4.gif"));
		} catch (IOException e) {
		}
		
		HeroStat heroStatRatio=new HeroStat(0.9, 0.05, 0.05); // summ ==1
		HeroStat heroStat=new HeroStat(strp, vitp, intp);
		
		//public void init(String name,  Image inImage, double inDeltaExp, double statPointPerLvl, HeroStat heroStat, HeroStat heroStatRatio,double strToPowerRatio,double vitToTTLRatio) {
		init(name, image, deltaExp, statPointPerLvl,heroStat,heroStatRatio,strToPowerRatio,vitToTTLRatio,htmlTextHeroTip,costGold,costSoul,costTear);
		
		//LHoH.gameScreen.heroAbilityStock.useAllAbilityByHero(heroId);
		

	}

	public void addHeroAbilities(){
		
		
	}
	




}
