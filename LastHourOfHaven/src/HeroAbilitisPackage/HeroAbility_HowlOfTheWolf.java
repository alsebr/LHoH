package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.LHoH;

public class HeroAbility_HowlOfTheWolf extends HeroAbility {

	public HeroAbility_HowlOfTheWolf(int heroId, int value) {
		super();
		setAbilityValue1(value);
		init(heroId, "Вой лютоволка");
	}

	@Override
	protected
	void update() {
	}

	void useAbility() {
		
		
		
		
		Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(heroId);
		tmpHero.addPower_bonus(getAbilityValue1());
		
		

	}

	String getAbilityTip() {
		
		String htmltext = "";
		//double tmppower = abilitypower;

		htmltext += "Вой лютоволка: " + String.format("%.2g%n", getAbilityValue1());

		return htmltext;

	}
	


}
