package LHoH;

public class HeroAbility_Imp extends HeroAbility {

	HeroAbility_Imp(int heroId) {
		super();

		init(heroId, "Бесовская хитрость");
		// TODO Auto-generated constructor stub
	}

	@Override
	void update() {

	}

	void useAbility() {
		// Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(heroId);
		// tmpHero.addPower_bonus((tmpHero).getHeroStat().intp);
		Location tmpLoc = LHoH.gameScreen.locationScope
				.getLocationByHeroId(heroId);

		if (tmpLoc != null) {
			if (tmpLoc.name == "Пещера бесов") {
				tmpLoc.addBonus50Gold_modify(50);
				System.out.println("123+");
			}
		}

	}

	String getAbilityTip() {
		String htmltext = "";
		double tmppower = 0;

		htmltext += "имп: +" + tmppower;

		return htmltext;

	}

}
