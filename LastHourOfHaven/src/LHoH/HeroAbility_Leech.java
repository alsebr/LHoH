package LHoH;

public class HeroAbility_Leech extends HeroAbility {

	public HeroAbility_Leech(int heroId) {
		super();
		init(heroId, "Вытягивание сил");
		setAbilityValue1(0); //% паура с пожирания
		setAbilityValue2(0); // текущий бонус
	}

	@Override
	void update() {

	}

	void useAbility() {
		Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(heroId);
		
		setAbilityValue1((double)(tmpHero).getHeroStat().intp/4000);
		
		Location tmpLoc = LHoH.gameScreen.locationScope
				.getLocationByHeroId(heroId);

		if (tmpLoc != null) {
			
		setAbilityValue2(getAbilityValue2()+getAbilityValue1());
		tmpLoc.decPower(getAbilityValue1());
		}
		

		
		tmpHero.addPower_bonus(getAbilityValue2());
		

	}

	String getAbilityTip() {
		String htmltext = "";
		htmltext += "Вытягивание сил: +" + String.format("%.4g%n", getAbilityValue2())+" ("+String.format("%.2g%n", getAbilityValue1()*60)+" мощи за секунду)";

		return htmltext;
	}
}
