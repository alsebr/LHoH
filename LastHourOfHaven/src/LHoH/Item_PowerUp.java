package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Item_PowerUp extends Item {
	public Item_PowerUp(int grade) {
		super();
		try {
			image = ImageIO.read(new File("data/image/item/item12.gif"));
		} catch (IOException e) {
		}
		this.grade = grade;
		String tmptext="<html>";
		tmptext+="���������� ������ Tier "+grade+"<br>������������:<br> ��������� ���� ��������";
		setToolTipText(tmptext);
	}

	void activateItem() {
		String tmpText;
		int addGold, addSoul;

		Hero tmp = null;

		for (Hero hero : HeroStock.allScope) {
			if (hero.status == 1) {
				tmp = hero;
			}
		}
		if (tmp != null) {

			LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_Imp(
					getId()));
			tmpText = tmp.name + " ��� ������� ������� ��������! (+25 ����)";

			LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_DemonicSignet(tmp.getId(),(grade+1)*14));
			LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);

			SelfDestroy();
		}

	}

}
