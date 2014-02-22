package LHoH;

public class HeroAbility_HowlOfTheWolf extends HeroAbility {

	HeroAbility_HowlOfTheWolf(int heroId, int value) {
		super();
		setAbilityValue1(value);
		init(heroId, "Вой лютоволка");
	}

	@Override
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
