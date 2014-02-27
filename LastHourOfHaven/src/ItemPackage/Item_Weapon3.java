package ItemPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import HeroAbilitisPackage.HeroAbility_BrokenClock;
import HeroAbilitisPackage.HeroAbility_FireSword;
import HeroAbilitisPackage.HeroAbility_ScytheofDeatch;
import LHoH.Item;
import LHoH.LHoH;

public class Item_Weapon3 extends Item{
public Item_Weapon3(int grade) {

	super();
	
	this.grade=grade;
try {
	image = ImageIO.read(new File("data/image/item/item17.gif"));
} catch (IOException e) {
}

double tmpValue=0;
if (grade==0) tmpValue=7;
if (grade==1) tmpValue=17;
if (grade==2) tmpValue=27;
if (grade==3) tmpValue=37;

//setTtl(10);
String tmptext;
tmptext="<html>";
tmptext+="Коса Рипера. <br>Пассивно:<br> +"+tmpValue+" мощь за каждый труп героя при сражении в Бесконечной башне";
setToolTipText(tmptext);

setName("Коса Рипера");

LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_ScytheofDeatch(tmpValue,getId()));

}



}
