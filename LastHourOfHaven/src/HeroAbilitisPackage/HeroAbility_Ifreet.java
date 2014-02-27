package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.LHoH;

public class HeroAbility_Ifreet extends HeroAbility {

	public HeroAbility_Ifreet(int heroId) {
		super();

		init(heroId, "������ ����");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected
	void update() {

	}

	public void useAbility() {
		if (LHoH.gameScreen.itemStock.checkItemCount("�������� ���") > 0) {

			Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(heroId);
			tmpHero.addPower_bonus((tmpHero).getHeroStat().intp*LHoH.gameScreen.itemStock.checkItemCount("�������� ���"));

		}
	}

	public String getAbilityTip() {
		String htmltext = "";
		double tmppower = 0;
		if (LHoH.gameScreen.itemStock.checkItemCount("�������� ���") > 0) {

			Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(heroId);
			tmppower = (tmpHero).getHeroStat().intp*LHoH.gameScreen.itemStock.checkItemCount("�������� ���");

		}

		htmltext += "������ ����: +" + String.format("%.4g%n",tmppower);

		return htmltext;

	}

}
