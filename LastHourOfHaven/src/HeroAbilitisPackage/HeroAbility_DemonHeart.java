package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.HeroStat;
import LHoH.LHoH;

public class HeroAbility_DemonHeart extends HeroAbility {

	public HeroAbility_DemonHeart(double value) {
		super();

		init(-1, "√невное сердце");
		
		setAbilityValue1(value); // +int
		
		
		setSequenceNumberStatModify();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	protected
	void update() {

	}

	public void useAbilityForHeroId(int id) {
		Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(id);
		tmpHero.addHeroStat_bonus(new HeroStat(getAbilityValue1(), 0, 0));
		
		

	}

	public String getAbilityTip() {
		String htmltext = "";
		

		htmltext += "√невное сердце: " + getAbilityValue1()+" str";

		return htmltext;

	}

}
