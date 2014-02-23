package LHoH;

import java.util.ArrayList;
import java.util.List;

public class HeroAbilityStock {
	List<HeroAbility> allScope = new ArrayList<HeroAbility>();

	HeroAbilityStock() {

	}

	void update() {

		List<HeroAbility> tmpScope = new ArrayList<HeroAbility>();

		for (HeroAbility heroAbility : allScope) {
			if (heroAbility.isFlagRemoveThisTick()) {
				tmpScope.add(heroAbility);
			}
		}
		
		for (HeroAbility heroAbility : tmpScope) {
				allScope.remove(heroAbility);
		}

		for (HeroAbility heroAbility : allScope) {
			heroAbility.update();

		}
	}

	public void addAbility(HeroAbility heroAbility) {
		allScope.add(heroAbility);
	}

	public HeroAbility getHeroAbilityByItemId(int itemId) {

		for (HeroAbility heroAbility : allScope) {
			if (heroAbility.getItemId() == itemId)
				return heroAbility;
		}
		return null;
	}

	String getAllAbilityTipByHero(int heroId) {
		String tmptText = "";
		for (HeroAbility heroAbility : allScope) {
			if (heroAbility.heroId == heroId)
				tmptText += heroAbility.getAbilityTip() + "<br>";
		}

		for (HeroAbility heroAbility : allScope) {
			if (heroAbility.heroId == -1)
				tmptText += heroAbility.getAbilityTip() + "<br>";
		}

		return tmptText;
	}

	void useAllAbilityByHero(int heroId) {
		for (HeroAbility heroAbility : allScope) {
			if (heroAbility.heroId == heroId)
				heroAbility.useAbility();

		}

		for (HeroAbility heroAbility : allScope) {
			if (heroAbility.heroId == -1)
				heroAbility.useAbilityForHeroId(heroId);

		}

	}

}
