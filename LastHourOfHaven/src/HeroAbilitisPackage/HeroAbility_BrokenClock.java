package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.LHoH;
import LHoH.Location;

public class HeroAbility_BrokenClock extends HeroAbility {

	public HeroAbility_BrokenClock(int itemId, int value) {
		super();
		init(-1, "Сломанные часы");
		setAbilityValue1(value);
		setAbilityValue2((double) 1 / 60);
		setItemId(itemId);
	}

	@Override
	protected void update() {
	}

	public void useAbilityForHeroId(int id) {
		setAbilityValue1((double) getAbilityValue1()
				- (double) getAbilityValue2());

		Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(id);
		tmpHero.addTtl(-getAbilityValue2());
		if (getAbilityValue1() <= 0) {
			setFlagRemoveThisTick(true);
		}
	}

	public double getTimeLeft() {
		return getAbilityValue1();
	}

	public String getAbilityTip() {
		String htmltext = "";
		// double tmppower = abilitypower;
		htmltext += "Сломанные часы: "
				+ String.format("%.3g%n", getAbilityValue1()) + " секунд осталось";
		return htmltext;

	}

}
