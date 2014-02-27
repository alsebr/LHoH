package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.HeroStat;
import LHoH.LHoH;

public class HeroAbility_IroMaiden extends HeroAbility {

	public HeroAbility_IroMaiden(double value) {
		super();

		init(-1, "Железная дева");
		
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
		tmpHero.addHeroStat_bonus(new HeroStat(0, getAbilityValue1(), 0));
		
		

	}

	public String getAbilityTip() {
		String htmltext = "";
		

		htmltext += "Железная дева: " + getAbilityValue1()+" vit";

		return htmltext;

	}

}
