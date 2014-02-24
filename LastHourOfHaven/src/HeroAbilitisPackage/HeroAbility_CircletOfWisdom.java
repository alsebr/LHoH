package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.HeroStat;
import LHoH.LHoH;

public class HeroAbility_CircletOfWisdom extends HeroAbility {

	public HeroAbility_CircletOfWisdom(double value) {
		super();

		init(-1, "Венец разума");
		
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
		tmpHero.addHeroStat_bonus(new HeroStat(0, 0, getAbilityValue1()));
		
		System.out.println("Circlet used");

	}

	public String getAbilityTip() {
		String htmltext = "";
		

		htmltext += "Венец разума: " + getAbilityValue1()+" int";

		return htmltext;

	}

}
