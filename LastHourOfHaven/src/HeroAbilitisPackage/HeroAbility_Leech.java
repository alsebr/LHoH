package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.LHoH;
import LHoH.Location;

public class HeroAbility_Leech extends HeroAbility {

	public HeroAbility_Leech(int heroId) {
		super();
		init(heroId, "����������� ���");
		setAbilityValue1(0); //% ����� � ���������
		setAbilityValue2(0); // ������� �����
	}

	@Override
	protected
	void update() {

	}

	public void useAbility() {
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

	public String getAbilityTip() {
		String htmltext = "";
		htmltext += "����������� ���: +" + String.format("%.4g%n", getAbilityValue2())+" ("+String.format("%.2g%n", getAbilityValue1()*60)+" ���� �� �������)";

		return htmltext;
	}
}
