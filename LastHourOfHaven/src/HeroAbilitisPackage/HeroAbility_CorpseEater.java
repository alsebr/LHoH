package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.LHoH;

public class HeroAbility_CorpseEater extends HeroAbility {

	public HeroAbility_CorpseEater(int heroId) {
		super();
		init(heroId, "Архитектор плоти");
		setAbilityValue2(0);
		
		Hero tmpHeroCorpse;
		while ((tmpHeroCorpse=LHoH.gameScreen.heroStock.getRandomDeadHero())!=null) {
			setAbilityValue2(getAbilityValue2()+ tmpHeroCorpse.getPurePower());
			LHoH.gameScreen.heroStock.removeHeroById(tmpHeroCorpse.getId());
		}
		
		
		setAbilityValue1(0); //% паура с пожирания
		
	}

	@Override
	protected
	void update() {

	}

	public void useAbility() {
		Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(heroId);
		
		setAbilityValue1((tmpHero).getHeroStat().intp/120);
		
		
		tmpHero.addPower_bonus(getAbilityValue2()*getAbilityValue1());
		

	}

	public String getAbilityTip() {
		String htmltext = "";
		htmltext += "Архитектор плоти: +" + String.format("%.4g%n", getAbilityValue2()*getAbilityValue1())+"мощи ( мощь пожранных трупов "+String.format("%.5g%n", getAbilityValue2())+", "+String.format("%.4g%n", getAbilityValue1()*100)+"% реализовано)";

		return htmltext;
	}
}
