package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
		String htmlTextHeroTip = "Сердце огня.";
		htmlTextHeroTip += "<br> Любой ваш огненный предмет увеличивает мощь Ифрита на <b>Int</b>";
		Image image=null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon12.gif"));
		} catch (IOException e) {
		}
		
		HeroStat heroStatRatio=new HeroStat(0.6, 0.2, 0.2); // summ ==1
		HeroStat heroStat=new HeroStat(strp, vitp, intp);
		
		//public void init(String name,  Image inImage, double inDeltaExp, double statPointPerLvl, HeroStat heroStat, HeroStat heroStatRatio,double strToPowerRatio,double vitToTTLRatio) {
		init(name, image, deltaExp, statPointPerLvl,heroStat,heroStatRatio,strToPowerRatio,vitToTTLRatio,htmlTextHeroTip);
		
		//LHoH.gameScreen.heroAbilityStock.useAllAbilityByHero(heroId);
		//LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_Ifreet(getId()));
		
	}


	
	public void addHeroAbilities(){
		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_Ifreet(getId()));
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
