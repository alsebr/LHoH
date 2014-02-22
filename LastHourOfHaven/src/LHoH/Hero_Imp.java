package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hero_Imp extends Hero {
	public Hero_Imp() {

		super();
		
		String name="���";
		double deltaExp=5;
		double strp=34;
		double vitp=1;
		double intp=37;
		double statPointPerLvl=15;
		double strToPowerRatio=1;
		double vitToTTLRatio=0.9;		
		String htmlTextHeroTip = "��������� ��������.";
		htmlTextHeroTip += "<br> ���� ����������� ������ ����� ���������� <b>~Int</b>";
		
		Image image=null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon9.gif"));
		} catch (IOException e) {
		}
		
		HeroStat heroStatRatio=new HeroStat(0.33, 0.33, 0.34); // summ ==1
		HeroStat heroStat=new HeroStat(strp, vitp, intp);
		
		//public void init(String name,  Image inImage, double inDeltaExp, double statPointPerLvl, HeroStat heroStat, HeroStat heroStatRatio,double strToPowerRatio,double vitToTTLRatio) {
		init(name, image, deltaExp, statPointPerLvl,heroStat,heroStatRatio,strToPowerRatio,vitToTTLRatio,htmlTextHeroTip);
		
		//LHoH.gameScreen.heroAbilityStock.useAllAbilityByHero(heroId);
		

	}

	public void addHeroAbilities(){
		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_Imp(getId()));
		
	}
	




}
