package ItemPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import LHoH.Item;
import LHoH.LHoH;

public class Item_Casket extends Item {
	public Item_Casket(int grade) {
		super();
		this.grade=grade;
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
		int count = random.nextInt(5);
		count++;
		tmpText = "ERROR";
		
		Item tmpi=null;
		if (grade==0){
			
		
		switch (count) {
		case 0:
			tmpi=new Item_chest(0);
			
			break;
		case 1:
			tmpi=new Item_BrokenClock(0);

			break;	

		case 2:
			tmpi=new Item_PowerUp(0);
			
			break;
		case 3:
			tmpi=new Item_PowerUp(0);
			
			break;
			
		case 4:
			tmpi=new Item_Plague(0);

			break;
		case 5:
			tmpi=new Item_Plague(1);

			break;
		//case 5:
			//tmpText = "Открыв шкатулку вы обнаружили Огненный Меч";
			//LHoH.gameScreen.itemStock.allScope.add(new Item_Weapon1());
			//break;
		default:
			break;
		}
		}

		
		if (grade==1){
			
			
		switch (count) {
		case 0:
			tmpi=new Item_DemonHeart(0);

			break;
		case 1:
			tmpi=new Item_HeadOfTheDuke(0);

			break;	

		case 2:
			tmpi=new Item_Weapon3(0);

			break;
		case 3:
			tmpi=new Item_IronMaiden(0);
			break;
			
		case 4:
			tmpi=new Item_lamp();
			break;
		case 5:
			tmpi=new Item_BrokenClock(1);
	break;
		default:
			break;
		}
		}

		tmpText = "Открыв шкатулку вы обнаружили "+tmpi.getName();
		LHoH.gameScreen.itemStock.allScope.add(tmpi);
		LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);
		SelfDestroy();

	}

}
