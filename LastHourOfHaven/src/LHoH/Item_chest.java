package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Item_chest extends Item {
	public Item_chest() {
		super();
		try {
			image = ImageIO.read(new File("data/image/item/item2.gif"));
		} catch (IOException e) {
		}
	}

	void activateItem() {
		String tmpText;
		int addGold, addSoul;

		Random random = new Random();
		addGold = 5 + random.nextInt(10);
		addSoul = 1 + random.nextInt(2);

		if (random.nextInt(100) < 25) {
			tmpText = "Вы попытались открыть сундук, но это оказался Мимик.";
			double nexp=1;
			int nlvl;
			double npower,nttl;
			Image nimage;
			int nheroCostGold,nheroCostSoul,nheroCostTear;
			String nname;
			
		double inDeltaExp;
		double inDeltaPower;
			
			nname="Мимик";
			npower=21;
			nimage=null;
			try {
				nimage = ImageIO.read(new File("data/image/hero/demon20.gif"));
			} catch (IOException e) {
			}

			nttl=87;
			inDeltaExp=6;
			inDeltaPower=5;
			
			Hero hero=new Hero(nname, npower, nexp, nttl, "2", 1, nimage, inDeltaExp, inDeltaPower);
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
