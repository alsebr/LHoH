package HeroAbilitisPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Hero.Hero_LurkingEvil;
import LHoH.Hero;
import LHoH.HeroAbility;
import LHoH.LHoH;

public class HeroAbility_LurkingEvil extends HeroAbility {

	public HeroAbility_LurkingEvil(int heroId) {
		super();
		init(heroId, "Затаившееся зло");
		setAbilityValue1(0); //% паура с пожирания
		setAbilityValue2(0); // текущий бонус
		setAbilityValue3(0);
	}

	@Override
	protected
	void update() {

	}

	public void useAbility() {
		
		if (getAbilityValue3()==0){
			
		
		Hero_LurkingEvil tmpHero = (Hero_LurkingEvil)LHoH.gameScreen.heroStock.getHeroById(heroId);
		setAbilityValue1((tmpHero).getHeroStat().intp/10000);
		setAbilityValue2(getAbilityValue2()+getAbilityValue1());
		if (getAbilityValue2()>100) setAbilityValue2(100);
		
		if (getAbilityValue2()>=100){

			tmpHero.transform();
			setAbilityValue3(1);
		}
		
		//tmpHero.addPower_bonus(getAbilityValue2());
		}

	}

	public String getAbilityTip() {
		String htmltext = "";
		htmltext += "Затаившееся зло: " + String.format("%.4g%n", getAbilityValue2())+"% ("+String.format("%.2g%n", getAbilityValue1()*60)+"% в секунду)";

		return htmltext;
	}
}
