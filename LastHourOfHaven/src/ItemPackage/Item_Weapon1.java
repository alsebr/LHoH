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
public Item_Weapon1() {
super();
try {
	image = ImageIO.read(new File("data/image/item/item13.gif"));
} catch (IOException e) {
}

String tmptext;
tmptext="<html>";
tmptext+="�������� ���. <br>��������:<br> +30 ���� ��� �������� � ����������� �����";
setToolTipText(tmptext);

setName("�������� ���");

LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_FireSword(30));

}



}
