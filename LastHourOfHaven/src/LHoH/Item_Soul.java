package LHoH;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Item_Soul extends Item{
	public Item_Soul() {
		try {
			image = ImageIO.read(new File("data/image/item/item1.gif"));
		} catch (IOException e) {
		}
	}

}
