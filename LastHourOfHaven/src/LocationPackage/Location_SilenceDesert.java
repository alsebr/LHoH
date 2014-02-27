package LocationPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import LHoH.Location;

public class Location_SilenceDesert extends Location {
	public Location_SilenceDesert() {

		super();
		String inName = "Пустыня безмолвия";
		int inPower = 42;
		double inwinR = 0.4;
		double pLocation_max = 100;
		String imagePath = "loc7";
		double inbonus50Gold = (double) 0.0 / 60;
		double inbonus50Soul = (double) 0.15 / 60;
		double inbonus50Tear = 0;
		double inbonusALLexp = (double) 1.1 / 60;
		
		
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
	protected
	void doLocationDevastated() {

	}
}
