package ItemPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Hero.Hero_Mimic;
import HeroAbilitisPackage.HeroAbility_BrokenClock;
import HeroAbilitisPackage.HeroAbility_CircletOfWisdom;
import HeroAbilitisPackage.HeroAbility_DemonicSignet;
import LHoH.Hero;
import LHoH.Item;
import LHoH.LHoH;

public class Item_BrokenClock extends Item {
	public Item_BrokenClock(int grade) {
		super();
		this.grade = grade;
		try {
			image = ImageIO.read(new File("data/image/item/item16.gif"));
		} catch (IOException e) {
		}
		setTtl((grade+1) * 70);
		String tmptext = "<html>";
		tmptext += "Сломанные часы Tier " + grade
				+ "<br>Использовать:<br> Ваши существа перестают тратить время";
		setToolTipText(tmptext);

		// ttl=6;
	}

	protected void checkTimerAction(){
		setTtl(getTtl()+(double)1/60);
	
		
		HeroAbility_BrokenClock tmpab;
		tmpab=(HeroAbility_BrokenClock)LHoH.gameScreen.heroAbilityStock.getHeroAbilityByItemId(getId());
		if (tmpab!=null){
			
			setTtl(tmpab.getTimeLeft());
		}
		else{
			if (isFlagItemWasActivated()){
				SelfDestroy();
				
				
			}
		}
		
	}

	public void activateItem() {

		if (!isFlagItemWasActivated()) {
			setFlagItemWasActivated(true);
			String tmpText = " Стрелка сломанных часов задвигалась в обратно направлении. Ваши герои больше не тратят время жизни";

			LHoH.gameScreen.heroAbilityStock
					.addAbility(new HeroAbility_BrokenClock(getId(), (int)getTtl()));
			
			LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_CircletOfWisdom(13));
			
			
			LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);

		}
	}

}
