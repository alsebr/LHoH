package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.LHoH;

public class HeroAbility_PowerUpAll extends HeroAbility {

	HeroAbility_PowerUpAll() {
		super();

		init(-1, "��������");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected
	void update() {

	}

	public void useAbilityForHeroId(int id) {
		Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(id);
		tmpHero.addPower_bonus(-25);

	}

	public String getAbilityTip() {
		String htmltext = "";
		double tmppower = -25;

		htmltext += "��������: " + tmppower;

		return htmltext;

	}

}
