package ItemPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Hero.Hero_Mimic;
import LHoH.Hero;
import LHoH.Item;
import LHoH.LHoH;

public class Item_BrokenClock extends Item {
	public Item_BrokenClock(int grade) {
		super();
		this.grade=grade;
		try {
			image = ImageIO.read(new File("data/image/item/item16.gif"));
		} catch (IOException e) {
		}
		
		String tmptext="<html>";
		tmptext+="Сломанные часы Tier "+grade+"<br>Использовать:<br> Ваши существа перестают тратить время";
		setToolTipText(tmptext);
		
		//ttl=6;
	}

	public void activateItem() {
		String tmpText;
		int addGold, addSoul;

		Random random = new Random();
		addGold = 5*(grade+1) + random.nextInt(4);
		addSoul = 1*(grade+1) + random.nextInt(1);

		if (random.nextInt(100) < 25) {
			tmpText = "Вы попытались открыть сундук, но это оказался Мимик.";

			Hero hero=new Hero_Mimic();
			LHoH.gameScreen.heroStock.addHero(hero);
			
			
		} else {
			tmpText = "Открыв сундук вы обнаружили: ";
			tmpText += "золота " + addGold;
			tmpText += ", душ " + addSoul;
			LHoH.gameScreen.player.addGold(addGold);
			LHoH.gameScreen.player.addSoul(addSoul);
		}

		LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);
		SelfDestroy();

	}

}
