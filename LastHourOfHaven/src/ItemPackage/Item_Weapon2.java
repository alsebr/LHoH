package ItemPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import HeroAbilitisPackage.HeroAbility_BrokenClock;
import HeroAbilitisPackage.HeroAbility_CircletOfWisdom;
import HeroAbilitisPackage.HeroAbility_FireSword;
import LHoH.Item;
import LHoH.LHoH;

public class Item_Weapon2 extends Item{
public Item_Weapon2(int grade) {
super();
this.grade=grade;
try {
	image = ImageIO.read(new File("data/image/item/item18.gif"));
} catch (IOException e) {
}
//setTtl(10);
double tmpValue=(grade+1)*3;
String tmptext;
tmptext="<html>";
tmptext+="Копье Завоевателя. <br>Активно:<br> прибавляет "+tmpValue+"% прогресса сражения в Бесконечной башне, предмет уходит на перезарядку";
setToolTipText(tmptext);

setName("Копье Завоевателя");

LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_FireSword(tmpValue,getId()));

}

public void activateItem() {

	if (!isFlagItemWasActivated()) {
		setFlagItemWasActivated(true);
		String tmpText = "Вы использовали Копье Завоевателя";
		LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);
		
		LHoH.gameScreen.heroAbilityStock
				.addAbility(new HeroAbility_BrokenClock(getId(), (int)getTtl()));
		
		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_CircletOfWisdom(13));
		
		setTtl(90);
		
	}
}

}
