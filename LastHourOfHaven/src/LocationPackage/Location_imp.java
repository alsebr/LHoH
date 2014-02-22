package LocationPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import LHoH.Location;

public class Location_imp extends Location {
	public Location_imp() {

		super();
		String inName = "Пещера бесов";
		int inPower = 36;
		double inwinR = 0.2;
		double pLocation_max = 100;
		String imagePath = "loc2";
		double inbonus50Gold = (double) 0.2 / 60;
		double inbonus50Soul = (double) 0.0 / 60;
		double inbonus50Tear = 0;
		double inbonusALLexp = (double) 1.5 / 60;
		
		
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
