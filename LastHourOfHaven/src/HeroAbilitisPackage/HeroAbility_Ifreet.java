package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.LHoH;

public class HeroAbility_Ifreet extends HeroAbility {

	public HeroAbility_Ifreet(int heroId) {
		super();

		init(heroId, "Сердце огня");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected
	void update() {

	}

	void useAbility() {
		if (LHoH.gameScreen.itemStock.checkItemCount("Огненный меч") > 0) {

			Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(heroId);
			tmpHero.addPower_bonus((tmpHero).getHeroStat().intp*LHoH.gameScreen.itemStock.checkItemCount("Огненный меч"));

		}
	}

	String getAbilityTip() {
		String htmltext = "";
		double tmppower = 0;
		if (LHoH.gameScreen.itemStock.checkItemCount("Огненный меч") > 0) {

			Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(heroId);
			tmppower = (tmpHero).getHeroStat().intp*LHoH.gameScreen.itemStock.checkItemCount("Огненный меч");

		}

		htmltext += "Сердце огня: +" + String.format("%.4g%n",tmppower);

		return htmltext;

	}

}
