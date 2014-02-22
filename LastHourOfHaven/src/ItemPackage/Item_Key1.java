package ItemPackage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import LHoH.Item;

public class Item_Key1 extends Item{
	public Item_Key1() {
		try {
			image = ImageIO.read(new File("data/image/item/item9.gif"));
		} catch (IOException e) {
		}
		setName("Демонический ключ");
		
		setToolTipText("Позволяет зайти на нижние этажи Бесконечной Башни");
	}
}
