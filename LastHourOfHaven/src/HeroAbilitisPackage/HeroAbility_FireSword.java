package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.HeroStat;
import LHoH.LHoH;

public class HeroAbility_FireSword extends HeroAbility {

	public HeroAbility_FireSword(double value) {
		super();

		init(-2, "Огненный меч");
		
		setAbilityValue1(value); // +int
		
		
		setSequenceNumberStatModify();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	protected
	void update() {

	}

	public void bossUse(){
		(LHoH.gameScreen.towerPanel.towerFight.getBoss()).addHeroPower_bonus(getAbilityValue1());
	}
	
	public String getAbilityTip() {
		String htmltext = "";
		

		htmltext += "Огненный меч: +" + getAbilityValue1()+" мощи";

		return htmltext;

	}

}
