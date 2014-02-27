package ItemPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Hero.Hero_Mimic;
import HeroAbilitisPackage.HeroAbility_BrokenClock;
import HeroAbilitisPackage.HeroAbility_CircletOfWisdom;
import HeroAbilitisPackage.HeroAbility_DemonHeart;
import HeroAbilitisPackage.HeroAbility_DemonicSignet;
import HeroAbilitisPackage.HeroAbility_FireSword;
import LHoH.Hero;
import LHoH.Item;
import LHoH.LHoH;

public class Item_DemonHeart extends Item {
	public Item_DemonHeart(int grade) {
		super();
		this.grade = grade;
		try {
			image = ImageIO.read(new File("data/image/item/item20.gif"));
		} catch (IOException e) {
		}
		//setTtl((grade+1) * 70);
		
		
		
		
		double tmpValue=0;
		if (grade==0) tmpValue=8;
		if (grade==1) tmpValue=16;
		if (grade==2) tmpValue=24;
		if (grade==3) tmpValue=32;

		
		String tmptext = "<html>";
		tmptext += "√невное сердце"
				+ "<br>ѕассивно:<br> +"+tmpValue+" str всем вашим геро€м";
		setToolTipText(tmptext);

		setName("√невное сердце");

		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_DemonHeart(tmpValue));
		// ttl=6;
	}

	protected void checkTimerAction(){
		
	}

	public void activateItem() {
	}

}
