package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Item_Plague extends Item{
public Item_Plague() {
super();
try {
	image = ImageIO.read(new File("data/image/item/item11.gif"));
} catch (IOException e) {
}


setToolTipText("��������� ������ � ����������� �����");
}

void activateItem(){
	int td;
	td=(int)(LHoH.gameScreen.towerPanel.towerFight.bossPower*0.3);
	LHoH.gameScreen.towerPanel.towerFight.bossPower=LHoH.gameScreen.towerPanel.towerFight.bossPower-td;
	
	String tmpText="���� ��������� �� �������. ���� ����� � ����������� ����� ��������� �� "+td;
	LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);
	SelfDestroy();
}

}
