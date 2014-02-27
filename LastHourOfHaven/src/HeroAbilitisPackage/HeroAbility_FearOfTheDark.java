package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.LHoH;

public class HeroAbility_FearOfTheDark extends HeroAbility {

	public HeroAbility_FearOfTheDark(int heroId) {
		super();

		init(heroId, "Страх темноты");
		setAbilityValue1(0); 
		setAbilityValue2(0); 
	}

	@Override
	protected
	void update() {

	}

	public void useAbility() {
		
		Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(heroId);
		setAbilityValue1((double)(tmpHero).getHeroStat().intp/100);
		
		tmpHero.addPower_bonus(tmpHero.getPurePower()*getAbilityValue1());

		
	}

	public String getAbilityTip() {
		String htmltext = "";
		double tmppower=getAbilityValue1()*100;
		
		htmltext += "Страх темноты: +" + String.format("%.4g%n",tmppower)+"% мощи";

		return htmltext;

	}

}
