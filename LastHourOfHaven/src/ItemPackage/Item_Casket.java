package ItemPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import LHoH.Item;
import LHoH.LHoH;

public class Item_Casket extends Item {
	public Item_Casket() {
		super();
		try {
			image = ImageIO.read(new File("data/image/item/item14.gif"));
		} catch (IOException e) {
		}

		String tmptext;
		tmptext = "<html>";
		tmptext += "Демоническая шкатулка. <br>Использовать:<br> в шкатулке может оказаться что-то полезное";
		setToolTipText(tmptext);
	}

	public void activateItem() {
		String tmpText;
		int addGold, addSoul;

		Random random = new Random();
		int count = random.nextInt(4);
		count++;
		tmpText = "ERROR";
		switch (count) {
		case 0:
			tmpText = "Открыв шкатулку вы обнаружили Демонический сундук";
			LHoH.gameScreen.itemStock.allScope.add(new Item_chest(0));
			break;
		case 1:
			tmpText = "Открыв шкатулку вы обнаружили Сломанные часы";
			LHoH.gameScreen.itemStock.allScope.add(new Item_BrokenClock(1));
			break;	

		case 2:
			tmpText = "Открыв шкатулку вы обнаружили Нечистивую печать";
			LHoH.gameScreen.itemStock.allScope.add(new Item_PowerUp(0));
			break;
		case 3:
			tmpText = "Открыв шкатулку вы обнаружили Нечистивую печать";
			LHoH.gameScreen.itemStock.allScope.add(new Item_PowerUp(1));
			break;
			
		case 4:
			tmpText = "Открыв шкатулку вы обнаружили Склянку с чумой";
			LHoH.gameScreen.itemStock.allScope.add(new Item_Plague(1));
			break;
		//case 5:
			//tmpText = "Открыв шкатулку вы обнаружили Огненный Меч";
			//LHoH.gameScreen.itemStock.allScope.add(new Item_Weapon1());
			//break;
		default:
			break;
		}



		LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);
		SelfDestroy();

	}

}
