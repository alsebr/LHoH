package LHoH;

import java.awt.Image;

public class Hero_Ifreet extends Hero {
	public Hero_Ifreet() {
		super();
		
		
		String name="Ифрит";
		double deltaExp=5;
		double strp=46;
		double vitp=71;
		double intp=21;
		double statPointPerLvl=5;
		double strToPowerRatio=1;
		double vitToTTLRatio=0.9;		
		Image image=null;
		
		
		HeroStat heroStatRatio=new HeroStat(0.6, 0.2, 0.2); // summ ==1
		HeroStat heroStat=new HeroStat(strp, vitp, intp);
		
		//public void init(String name,  Image inImage, double inDeltaExp, double statPointPerLvl, HeroStat heroStat, HeroStat heroStatRatio,double strToPowerRatio,double vitToTTLRatio) {
		init(name, image, deltaExp, statPointPerLvl,heroStat,heroStatRatio,strToPowerRatio,vitToTTLRatio);
		
		//LHoH.gameScreen.heroAbilityStock.useAllAbilityByHero(heroId);
		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_Ifreet(getId()));
		
	}

	/*
	@Override
	
	public double getBonusPower() {
		// TODO Auto-generated method stub
		double tmppower = 0;

		if (LHoH.gameScreen.itemStock.checkItemCount("Огненный меч") > 0) {
			tmppower += getHeroStat().intp;
		}

		return tmppower;
	}
*/
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
