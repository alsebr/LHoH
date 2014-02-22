package ItemPackage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import LHoH.Item;

public class Item_Soul extends Item{
	public Item_Soul() {
		try {
			image = ImageIO.read(new File("data/image/item/item1.gif"));
		} catch (IOException e) {
		}
	}

}
