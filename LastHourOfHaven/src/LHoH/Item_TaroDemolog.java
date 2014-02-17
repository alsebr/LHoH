package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Item_TaroDemolog extends Item{
	
	Item_TaroDemolog(){
	super();
	try {
		image = ImageIO.read(new File("data/image/item/item8.gif"));
	} catch (IOException e) {
	}
	}
	
	void activateItem(){
		String tmpText;
		int addGold,addSoul;
		tmpText="С помощью карты таро Маг вы призываете Ловца Снов";
		
		
		
		LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);

		double nexp=1;
		int nlvl;
		double npower,nttl;
		Image nimage;
		int nheroCostGold,nheroCostSoul,nheroCostTear;
		String nname;
		
	double inDeltaExp;
	double inDeltaPower;
		
		nname="Ловец Снов";
		npower=20;
		nimage=null;
		try {
			nimage = ImageIO.read(new File("data/image/hero/demon17.gif"));
		} catch (IOException e) {
		}
		nheroCostGold=40;
		nheroCostSoul=2;
		nheroCostTear=0;//+random.nextInt(1);
		nttl=120;
		inDeltaExp=30;
		inDeltaPower=17;
		
		Hero heroT=new HeroDemolog(nname, npower, nexp, nttl, "2", 1, nimage, inDeltaExp, inDeltaPower);
		LHoH.gameScreen.heroStock.addHero(heroT);
		
		
		
		SelfDestroy();
	}
}
