package LHoH;

import java.util.ArrayList;
import java.util.List;

public class HeroAbilityStock {
	List<HeroAbility> allScope = new ArrayList<HeroAbility>();
	
	HeroAbilityStock (){
		
	}
	void update(){
		for (HeroAbility	 heroAbility : allScope) {
			heroAbility.update();

	}	
	}
	void addAbility(HeroAbility heroAbility){
		allScope.add(heroAbility);
	}
	
	String getAllAbilityTip(int heroId){
		return "";
	}
	
	void useAllAbilityByHero(int heroId){
		for (HeroAbility	 heroAbility : allScope) {
			if (heroAbility.heroId==heroId)	heroAbility.useAbility();

	}	
	}
	
}
