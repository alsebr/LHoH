package LHoH;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Item_Key2 extends Item{
	public Item_Key2() {
		try {
			image = ImageIO.read(new File("data/image/item/key2.gif"));
		} catch (IOException e) {
		}
		setName("Серебрянный ключ");
		
	}
}
