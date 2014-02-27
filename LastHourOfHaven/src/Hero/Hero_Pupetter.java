package Hero;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import HeroAbilitisPackage.HeroAbility_Leech;
import LHoH.Hero;
import LHoH.HeroStat;
import LHoH.LHoH;

public class Hero_Pupetter extends Hero {
	public Hero_Pupetter() {
		super();

		String name = "Кукловод";
		double costGold = 46;
		double costSoul = 24;
		double costTear = 1;
		double deltaExp = 10;
		double strp = 189;
		double vitp = 230;
		double intp = 61;
		double statPointPerLvl = 32;
		double strToPowerRatio = 1;
		double vitToTTLRatio = 2;
		String htmlTextHeroTip = "Вытягивание силы.";
		htmlTextHeroTip += "<br> Каждую секунду пиявка вытягивает силы из атакуемого Портала <b>Int</b>";
		Image image = null;
		try {
			image = ImageIO.read(new File("data/image/hero/demon1.gif"));
		} catch (IOException e) {
		}

		HeroStat heroStatRatio = new HeroStat(0.6, 0.2, 0.2); // summ ==1
		HeroStat heroStat = new HeroStat(strp, vitp, intp);

		init(name, image, deltaExp, statPointPerLvl, heroStat, heroStatRatio,
				strToPowerRatio, vitToTTLRatio, htmlTextHeroTip, costGold,
				costSoul, costTear);

	}

	public void addHeroAbilities() {
		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_Leech(
				getId()));
	}

}
