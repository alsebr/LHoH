package LHoH;

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
	
	void activateItem(){
		String tmpText;
		int addGold,addSoul;
		tmpText="Открыв сундук вы обнаружили: ";
		
		Random random = new Random();
		addGold=5+random.nextInt(10);
		addSoul=1+random.nextInt(2);
		
		tmpText+="золота "+ addGold;
		tmpText+=", душ "+ addSoul;
		
		LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);

		
		LHoH.gameScreen.player.addGold(addGold);
		LHoH.gameScreen.player.addSoul(addSoul);
		
		SelfDestroy();
	}

}
