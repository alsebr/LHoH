package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Location_WarriorOfTheLight extends Location {
	Location_WarriorOfTheLight() {

		super();
		String inName = "Воин света";
		int inPower = 146;
		double inwinR = 0.2;
		double pLocation_max = 100;
		String imagePath = "loc6";
		double inbonus50Gold = (double) 0.9 / 60;
		double inbonus50Soul = (double) 0.7 / 60;
		double inbonus50Tear = 0;
		double inbonusALLexp = (double) 1.8 / 60;
		
		
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

	}
}
