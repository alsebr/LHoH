package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.HeroStat;
import LHoH.LHoH;

public class HeroAbility_SoulKnife extends HeroAbility {

	public HeroAbility_SoulKnife(double value, int itemId) {
		super();

		init(-2, "Кинжал душ");
		
		setAbilityValue1(value); // +int
		setAbilityValue2(itemId);
		setAbilityValue3(0);
		
		
		
		setSequenceNumberDefault();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	protected
	void update() {
		
		setAbilityValue3(LHoH.gameScreen.heroStock.getCorpsesAmount()*getAbilityValue1());
		dieIfNoItemWithId((int)getAbilityValue2());
	}

	public void bossUse(){
		(LHoH.gameScreen.towerPanel.towerFight.getBoss()).addHeroPower_bonus(getAbilityValue3());
	}
	
	public String getAbilityTip() {
		String htmltext = "";
		

		htmltext += "kos: +" + getAbilityValue1()+" мощи";

		return htmltext;

	}

}
