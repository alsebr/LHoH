package LocationPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import LHoH.Location;

public class Location_GraveOfTheChosenOne extends Location {
	public Location_GraveOfTheChosenOne() {

		super();
		String inName = "Могила Избранного";
		int inPower =72;
		double inwinR = 0.2;
		double pLocation_max = 22;
		String imagePath = "loc10";
		double inbonus50Gold = (double) 0.9 / 60;
		double inbonus50Soul = (double) 0.14 / 60;
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
