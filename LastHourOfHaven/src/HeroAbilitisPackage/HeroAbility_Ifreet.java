package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.LHoH;

public class HeroAbility_Ifreet extends HeroAbility {

	public HeroAbility_Ifreet(int heroId) {
		super();

		init(heroId, "Сердце огня");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected
	void update() {

	}

	public void useAbility() {
		
		double tmpvalue=0;
		tmpvalue+=LHoH.gameScreen.itemStock.checkItemCount("Пылающий меч");
		tmpvalue+=LHoH.gameScreen.itemStock.checkItemCount("Гневное сердце");
				Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(heroId);
		tmpHero.addPower_bonus(tmpvalue*(tmpHero).getHeroStat().intp);
	}

	public String getAbilityTip() {
		String htmltext = "";
		double tmppower = 0;
		
		tmppower+=LHoH.gameScreen.itemStock.checkItemCount("Пылающий меч");
		tmppower+=LHoH.gameScreen.itemStock.checkItemCount("Гневное сердце");
		
		
			Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(heroId);
			tmppower = (tmpHero).getHeroStat().intp*tmppower;

		

		htmltext += "Сердце огня: +" + String.format("%.4g%n",tmppower);

		return htmltext;

	}

}
