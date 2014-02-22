package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Location_ForgottenForest extends Location {
	Location_ForgottenForest() {

		super();
		String inName = "Забытый лес";
		int inPower = 45;
		double inwinR = 0.4;
		double pLocation_max = 80;
		String imagePath = "loc5";
		double inbonus50Gold = (double) 0.3 / 60;
		double inbonus50Soul = (double) 0.07 / 60;
		double inbonus50Tear = 0;
		double inbonusALLexp = (double) 1.7 / 60;
		
		
		Image inEnemy=null;
		try {
			inEnemy = ImageIO.read(new File("data/image/loc/"+imagePath+".gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		init(inName, inPower, inwinR, inEnemy, inbonus50Gold, inbonus50Soul,
				inbonus50Tear, inbonusALLexp, pLocation_max);
	}

	@Override
	void doLocationDevastated() {
		LHoH.gameScreen.itemStock.allScope.add(new Item_Casket());
		LHoH.gameScreen.bottomInfo.chat.addTextChat("В глубине леса вы нашли странную шкатулку");
	}
}
