package LHoH;

public class HeroAbility_Ifreet extends HeroAbility {

	HeroAbility_Ifreet(int heroId) {
		super();

		init(heroId, "������ ����");
		// TODO Auto-generated constructor stub
	}

	@Override
	void update() {

	}

	void useAbility() {
		if (LHoH.gameScreen.itemStock.checkItemCount("�������� ���") > 0) {

			Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(heroId);
			tmpHero.addPower_bonus((tmpHero).getHeroStat().intp);

		}
	}

	String getAbilityTip() {
		String htmltext = "";
		double tmppower = 0;
		if (LHoH.gameScreen.itemStock.checkItemCount("�������� ���") > 0) {

			Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(heroId);
			tmppower = (tmpHero).getHeroStat().intp;

		}

		htmltext += "������ ����: +" + tmppower;

		return htmltext;

	}

}
