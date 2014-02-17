package LHoH;

import java.awt.Image;
import java.util.Random;

public class HeroDemolog extends Hero{
public HeroDemolog(String name, double power,double exp,double ttl, String  classH, int zoneId, Image inImage, double inDeltaExp, double inDeltaPower) {
	super(name,power,exp,ttl,classH,zoneId,inImage,inDeltaExp,inDeltaPower);
}

protected void Update(){
	super.Update();
	
	Random random = new Random();
	int count=random.nextInt(1000);
	
	if (count<50){
		LHoH.gameScreen.bottomInfo.chat.addTextChat("name проводит нечистивый ритуал и призывает беса");
		
	}
	
}
}
