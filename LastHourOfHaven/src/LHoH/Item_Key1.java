package LHoH;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Item_Key1 extends Item{
	public Item_Key1() {
		try {
			image = ImageIO.read(new File("data/image/item/key1.gif"));
		} catch (IOException e) {
		}
		setName("Демонический ключ");
		
	}
}
