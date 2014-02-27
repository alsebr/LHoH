package ItemPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import LHoH.Boss;
import LHoH.Item;
import LHoH.LHoH;

public class Item_Plague extends Item{
public Item_Plague(int grade) {
super();
try {
	image = ImageIO.read(new File("data/image/item/item11.gif"));
} catch (IOException e) {
}
setName("������� � �����");
this.grade=grade;
String tmptext="<html>";
tmptext+="������� � ����� Tier "+grade+"<br>������������:<br> ��������� ������ � ����������� �����";
setToolTipText(tmptext);
}

public void activateItem(){
	int td;
	Boss boss=LHoH.gameScreen.towerPanel.towerFight.getBoss(); 
	td=(int)(boss.getPowerCurrent()*0.15*(grade+1));
	boss.setPowerCurrent(boss.getPowerCurrent()-td);
	LHoH.gameScreen.towerPanel.towerFight.bossPower=LHoH.gameScreen.towerPanel.towerFight.bossPower-td;
	
	String tmpText="���� ��������� �� �������. ���� ����� � ����������� ����� ��������� �� "+td;
	LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);
	SelfDestroy();
}

}
