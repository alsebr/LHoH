package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Item_Casket extends Item {
	public Item_Casket() {
		super();
		try {
			image = ImageIO.read(new File("data/image/item/item14.gif"));
		} catch (IOException e) {
		}
		
		String tmptext;
		tmptext="<html>";
		tmptext+="������������ ��������. <br>������������:<br> � �������� ����� ��������� ���-�� ��������";
		setToolTipText(tmptext);
	}

	void activateItem() {
		String tmpText;
		int addGold, addSoul;

		LHoH.gameScreen.itemStock.allScope.add(new Item_Weapon1());
		
			tmpText = "������ �������� �� ���������� �������� ���";
		LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);
		SelfDestroy();

	}

}
