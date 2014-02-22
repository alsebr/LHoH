package HeroAbilitisPackage;

import LHoH.HeroAbility;
import LHoH.LHoH;
import LHoH.Location;

public class HeroAbility_Imp extends HeroAbility {

	public HeroAbility_Imp(int heroId) {
		super();
		init(heroId, "Бесовская хитрость");
	}

	@Override
	protected
	void update() {
	}

	void useAbility() {
		
		setAbilityValue1((double)0.002/60*  LHoH.gameScreen.heroStock.getHeroById(heroId).getHeroStat().intp);
		setAbilityValue2((double)0.002/60*0.5*LHoH.gameScreen.heroStock.getHeroById(heroId).getHeroStat().intp);
		
		Location tmpLoc = LHoH.gameScreen.locationScope
				.getLocationByHeroId(heroId);

		if (tmpLoc != null) {
			if (tmpLoc.name == "Пещера бесов") {
				tmpLoc.addBonus50Gold_modify(getAbilityValue1());
				tmpLoc.addBonus50Soul_modify(getAbilityValue2());
				
			}
		}
		
		

	}

	String getAbilityTip() {
		
		String htmltext = "";
		//double tmppower = abilitypower;

		htmltext += "Бесовская хитрость: +" + String.format("%.2g%n", getAbilityValue1()*60)+" gold, "+String.format("%.2g%n", getAbilityValue2()*60)+" soul";

		return htmltext;

	}
	


}
