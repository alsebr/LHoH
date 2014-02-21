package LHoH;

public class HeroAbility_PowerUpAll extends HeroAbility {

	HeroAbility_PowerUpAll() {
		super();

		init(-1, "слабость");
		// TODO Auto-generated constructor stub
	}

	@Override
	void update() {

	}

	void useAbilityForHeroId(int id) {
		Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(id);
		tmpHero.addPower_bonus(-25);

	}

	String getAbilityTip() {
		String htmltext = "";
		double tmppower = -25;

		htmltext += "Слабость: " + tmppower;

		return htmltext;

	}

}
