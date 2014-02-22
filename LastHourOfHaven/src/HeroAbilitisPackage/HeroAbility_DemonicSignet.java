package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.LHoH;

public class HeroAbility_DemonicSignet extends HeroAbility {

	public HeroAbility_DemonicSignet(int heroId, int value) {
		super();
		setAbilityValue1(value);
		init(heroId, "Нечистивая печать");
	}

	@Override
	protected
	void update() {
	}

	public void useAbility() {
		
		
		setAbilityValue2((double)0.002/60*0.5*LHoH.gameScreen.heroStock.getHeroById(heroId).getHeroStat().intp);
		
		Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(heroId);
		tmpHero.addPower_bonus(getAbilityValue1());
		
		

	}

	public String getAbilityTip() {
		
		String htmltext = "";
		//double tmppower = abilitypower;

		htmltext += "Нечистивая печать: +" + String.format("%.2g%n", getAbilityValue1());

		return htmltext;

	}
	


}
