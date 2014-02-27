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
import HeroAbilitisPackage.HeroAbility_FireSword;
import HeroAbilitisPackage.HeroAbility_IroMaiden;
import LHoH.Hero;
import LHoH.Item;
import LHoH.LHoH;

public class Item_IronMaiden extends Item {
	public Item_IronMaiden(int grade) {
		super();
		this.grade = grade;
		try {
			image = ImageIO.read(new File("data/image/item/item21.gif"));
		} catch (IOException e) {
		}
		//setTtl((grade+1) * 70);
		
		
		
		
		double tmpValue=0;
		if (grade==0) tmpValue=15;
		if (grade==1) tmpValue=30;
		if (grade==2) tmpValue=45;
		if (grade==3) tmpValue=60;

		
		String tmptext = "<html>";
		tmptext += "Железная дева "
				+ "<br>Пассивно:<br> +"+tmpValue+" vit всем вашим героям";
		setToolTipText(tmptext);

		setName("Железная дева");

		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_IroMaiden(tmpValue));
		// ttl=6;
	}

	protected void checkTimerAction(){
		
	}

	public void activateItem() {
	}

}
