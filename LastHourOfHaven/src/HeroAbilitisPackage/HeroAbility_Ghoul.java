package HeroAbilitisPackage;

import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.LHoH;

public class HeroAbility_Ghoul extends HeroAbility {

	public HeroAbility_Ghoul(int heroId) {
		super();
		init(heroId, "��������� ������");
		setAbilityValue1(0); //% ����� � ���������
		setAbilityValue2(0); // ������� �����
	}



public void useAbility() {
		Hero tmpHero = LHoH.gameScreen.heroStock.getHeroById(heroId);
		
		setAbilityValue1((tmpHero).getHeroStat().intp/100);
		if (tmpHero.isFlagLvlUpThisTick()){
			Hero tmpHeroCorpse=LHoH.gameScreen.heroStock.getRandomDeadHero();
			if (tmpHeroCorpse!=null){
				setAbilityValue2(getAbilityValue2()+ tmpHeroCorpse.getPurePower()*getAbilityValue1());
				LHoH.gameScreen.heroStock.removeHeroById(tmpHeroCorpse.getId());
			}
		}
		
		tmpHero.addPower_bonus(getAbilityValue2());
		

	}

	public String getAbilityTip() {
		String htmltext = "";
		htmltext += "��������� ������: +" + String.format("%.4g%n", getAbilityValue2())+" ("+String.format("%.2g%n", getAbilityValue1()*100)+"% � ���������)";

		return htmltext;
	}
}
