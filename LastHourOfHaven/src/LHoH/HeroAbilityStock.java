package LHoH;

import java.util.ArrayList;
import java.util.List;

public class HeroAbilityStock {
	List<HeroAbility> allScope = new ArrayList<HeroAbility>();

	HeroAbilityStock() {

	}

	void update() {
		for (HeroAbility heroAbility : allScope) {
			heroAbility.update();

		}
	}

	void addAbility(HeroAbility heroAbility) {
		allScope.add(heroAbility);
	}

	String getAllAbilityTipByHero(int heroId) {
		String tmptText = "";
		for (HeroAbility heroAbility : allScope) {
			if (heroAbility.heroId == heroId)
				tmptText+=heroAbility.getAbilityTip()+"<br>";
		}
		
		for (HeroAbility heroAbility : allScope) {
			if (heroAbility.heroId == -1)
				tmptText+=heroAbility.getAbilityTip()+"<br>";
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
