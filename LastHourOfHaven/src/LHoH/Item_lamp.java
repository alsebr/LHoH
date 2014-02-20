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
	
	nname="Ифрит";
	npower=50;
	nimage=null;
	try {
		nimage = ImageIO.read(new File("data/image/hero/demon12.gif"));
	} catch (IOException e) {
	}
	nheroCostGold=40;
	nheroCostSoul=2;
	nheroCostTear=0;//+random.nextInt(1);
	nttl=300;
	inDeltaExp=30;
	inDeltaPower=17;
	
	Hero hero=new Hero_Ifreet(nname, npower, nexp, nttl, "2", 1, nimage, inDeltaExp, inDeltaPower);
	LHoH.gameScreen.heroStock.addHero(hero);
	
	SelfDestroy();
}

}
