package ItemPackage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import LHoH.Item;

public class Item_Key2 extends Item{
	public Item_Key2() {
		try {
			image = ImageIO.read(new File("data/image/item/item10.gif"));
		} catch (IOException e) {
		}
		setName("Серебрянный ключ");
		
		setToolTipText("Позволяет зайти на средние этажи Бесконечной Башни");
	}
}
