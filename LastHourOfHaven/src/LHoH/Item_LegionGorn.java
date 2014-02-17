package LHoH;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Item_LegionGorn extends Item{
	Item_LegionGorn(){
	super();
	try {
		image = ImageIO.read(new File("data/image/item/item3.gif"));
	} catch (IOException e) {
	}
	
	charge_max=8;
	
	}
	
	void checkCharge(){
		charge_now+=(double)1/60;
		if (charge_now>charge_max){
			
			charge_max=charge_max*1.2;
			
			charge_now=0;
			
			for (Hero hero : LHoH.gameScreen.heroStock.allScope) {
	    		hero.addPower(30);
	    		
	    	}
			
			
			String tmpText="ƒуши ваших воинов воспламен€т звук боевого горна!";
			LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);
		}
	}
}
