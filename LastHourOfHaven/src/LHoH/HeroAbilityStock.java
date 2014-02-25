package LHoH;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HeroAbilityStock {
	//private List<HeroAbility> allScope = new ArrayList<HeroAbility>();
	private PriorityQueue<HeroAbility> allScope = new PriorityQueue<HeroAbility>();

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
		//private List<HeroAbility> allScope = new ArrayList<HeroAbility>();
		
		
		
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
			if ((heroAbility.heroId == heroId)||(heroAbility.heroId == -1))
				tmptText += heroAbility.getAbilityTip() + "<br>";
		}



		return tmptText;
	}

	void useAllAbilityByHero(int heroId) {
		for (HeroAbility heroAbility : allScope) {
			if (heroAbility.heroId == heroId)
				heroAbility.useAbility();
			if (heroAbility.heroId == -1)
				heroAbility.useAbilityForHeroId(heroId);
		}

		}

		void useAllAbilityBoss() {
			for (HeroAbility heroAbility : allScope) {
				if (heroAbility.heroId == -2)
					heroAbility.bossUse();

			}
		

	}

}
