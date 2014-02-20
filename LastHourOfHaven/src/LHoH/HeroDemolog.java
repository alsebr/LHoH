package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class HeroDemolog extends Hero{
public HeroDemolog(String name, double power,double exp,double ttl, String  classH, int zoneId, Image inImage, double inDeltaExp, double inDeltaPower) {
//	super(name,power,exp,ttl,classH,zoneId,inImage,inDeltaExp,inDeltaPower);
}

protected void Update(){
	super.Update();
	
	Random random = new Random();
	int count=random.nextInt(1000);
	
	if (status==1){
	if (count<1){
		LHoH.gameScreen.bottomInfo.chat.addTextChat("Еще одна душа попала в сети Ловца Снов");
	ttl-=50;
	
	double nexp=1;
	int nlvl;
	double npower,nttl;
	Image nimage;
	int nheroCostGold,nheroCostSoul,nheroCostTear;
	String nname;
	
double inDeltaExp;
double inDeltaPower;
	
nname="Имп";
npower=25;
nimage=null;
try {
	nimage = ImageIO.read(new File("data/image/hero/demon9.gif"));
} catch (IOException e) {
}
nheroCostGold=10;
nheroCostSoul=1;//+random.nextInt(3);
nheroCostTear=0;//+random.nextInt(1);
nttl=60;
inDeltaExp=10;
inDeltaPower=4;
	
	//Hero hero=new Hero(nname, npower, nexp, nttl, "2", 1, nimage, inDeltaExp, inDeltaPower);
	//LHoH.gameScreen.heroStock.addHero(hero);
	LHoH.gameScreen.itemStock.allScope.add(new Item_Soul());


	
	}
	}
	
}
}
