package ItemPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import HeroAbilitisPackage.HeroAbility_BrokenClock;
import HeroAbilitisPackage.HeroAbility_FireSword;
import LHoH.Item;
import LHoH.LHoH;

public class Item_Weapon1 extends Item{
public Item_Weapon1(int grade) {

	super();
	
	this.grade=grade;
try {
	image = ImageIO.read(new File("data/image/item/item13.gif"));
} catch (IOException e) {
}

double tmpValue=0;
if (grade==0) tmpValue=30;
if (grade==1) tmpValue=70;
if (grade==2) tmpValue=120;
if (grade==3) tmpValue=180;

//setTtl(10);
String tmptext;
tmptext="<html>";
tmptext+="�������� ���. <br>��������:<br> +"+tmpValue+" ���� ��� �������� � ����������� �����";
setToolTipText(tmptext);

setName("�������� ���");

LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_FireSword(tmpValue,getId()));

}



}
