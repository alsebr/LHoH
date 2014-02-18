package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Item_PowerUp extends Item{
public Item_PowerUp() {
super();
try {
	image = ImageIO.read(new File("data/image/item/item12.gif"));
} catch (IOException e) {
}

setToolTipText("��������� ���� ��������");
}

void activateItem(){
	String tmpText;
	int addGold,addSoul;
	
	Hero tmp=null;
	
	for (Hero hero : HeroStock.allScope) {
		if (hero.status==1)	{
			tmp=hero;
		}
	}
	if (tmp!=null){
		tmpText=tmp.name+ " ��� ������� ������� ��������! (+25 ����)";
		tmp.power+=25;
		LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);

		
		
		SelfDestroy();	
	}
	
}

}