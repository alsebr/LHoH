package ItemPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import HeroAbilitisPackage.HeroAbility_DemonicSignet;
import HeroAbilitisPackage.HeroAbility_Imp;
import LHoH.Hero;
import LHoH.HeroStock;
import LHoH.Item;
import LHoH.LHoH;

public class Item_PowerUp extends Item {
	public Item_PowerUp(int grade) {
		super();
		try {
			image = ImageIO.read(new File("data/image/item/item12.gif"));
		} catch (IOException e) {
		}
		this.grade = grade;
		String tmptext="<html>";
		tmptext+="Нечистивая печать Tier "+grade+"<br>Использовать:<br> Усиливает ваше существо";
		setToolTipText(tmptext);
	}

	public void activateItem() {
		String tmpText;
		int addGold, addSoul;

		Hero tmp = LHoH.gameScreen.heroStock.getRandomAliveHero();


		if (tmp != null) {


			tmpText = tmp.name + " Был отмечен печатью Великого! ";

			LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_DemonicSignet(tmp.getId(),(grade+1)*14));
			LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);

			SelfDestroy();
		}

	}

}
