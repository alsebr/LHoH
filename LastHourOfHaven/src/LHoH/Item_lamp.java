package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Item_lamp extends Item{
public Item_lamp() {
super();
try {
	image = ImageIO.read(new File("data/image/item/item4.gif"));
} catch (IOException e) {
}

String tmptext="<html>";
tmptext+="Старая лампа <br>Использовать:<br> говорят в таких лампах могут жить Джины";
setToolTipText(tmptext);
}

void activateItem(){
	String tmpText;
	int addGold,addSoul;
	tmpText="Из лампы вырвался ифрит. -Я повинуюсь Вам, мой Лорд!";
	
	
	
	LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);

	double nexp=1;
	int nlvl;
	double npower,nttl;
	Image nimage;
	int nheroCostGold,nheroCostSoul,nheroCostTear;
	String nname;
	
double inDeltaExp;
double inDeltaPower;
	
	Hero hero=new Hero_Ifreet();
	hero.addHeroAbilities();
	LHoH.gameScreen.heroStock.addHero(hero);
	
	SelfDestroy();
}

}
