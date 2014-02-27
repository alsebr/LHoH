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

public class Item_Weapon4 extends Item{
public Item_Weapon4(int grade) {

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

setTtl(10);
String tmptext;
tmptext="<html>";
tmptext+="Жертвенный кинжал. <br>Пассивно:<br> +"+tmpValue+" мощь при сражении в Бесконечной башне";
tmptext+="<br>Активно:<br> +"+tmpValue+" приносит в жертву случайное существо, перезарядка 90 секунд";
setToolTipText(tmptext);

setName("Огненный меч");

LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_FireSword(tmpValue,getId()));

}



}
