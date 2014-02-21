package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hero_Imp extends Hero {
	public Hero_Imp() {

		super();
		
		String name="Имп";
		double deltaExp=5;
		double strp=34;
		double vitp=33;
		double intp=37;
		double statPointPerLvl=15;
		double strToPowerRatio=1;
		double vitToTTLRatio=0.9;		
		Image image=null;
		
		
		HeroStat heroStatRatio=new HeroStat(0.33, 0.33, 0.34); // summ ==1
		HeroStat heroStat=new HeroStat(strp, vitp, intp);
		
		//public void init(String name,  Image inImage, double inDeltaExp, double statPointPerLvl, HeroStat heroStat, HeroStat heroStatRatio,double strToPowerRatio,double vitToTTLRatio) {
		init(name, image, deltaExp, statPointPerLvl,heroStat,heroStatRatio,strToPowerRatio,vitToTTLRatio);
		
		//LHoH.gameScreen.heroAbilityStock.useAllAbilityByHero(heroId);
		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_Imp(getId()));
		
		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_PowerUpAll());

	}

	@Override
	public String getStatusTip() {
		// TODO Auto-generated method stub

		String htmltext = super.getStatusTip();
		double tmppower = 0;
		if (LHoH.gameScreen.itemStock.checkItemCount("Огненный меч") > 0) {
			tmppower += getHeroStat().intp;
		}

		htmltext += "Сердце огня: +" + tmppower;

		return htmltext;
	}

	@Override
	public String getHeroTip() {
		// TODO Auto-generated method stub
		String htmltext;// =super.getHeroTip();

		htmltext = "Сердце огня.";
		htmltext += "<br> Любой ваш огненный предмет увеличивает мощь Ифрита на <b>Int</b>";

		return htmltext;
	}

}
