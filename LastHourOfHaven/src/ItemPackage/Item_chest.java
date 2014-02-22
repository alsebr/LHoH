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

public class Item_chest extends Item {
	public Item_chest(int grade) {
		super();
		this.grade=grade;
		try {
			image = ImageIO.read(new File("data/image/item/item2.gif"));
		} catch (IOException e) {
		}
		
		setToolTipText("Содержит великие сокровища");
		
		//ttl=6;
	}

	void activateItem() {
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
