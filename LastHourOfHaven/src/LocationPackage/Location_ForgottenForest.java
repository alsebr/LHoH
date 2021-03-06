package LocationPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ItemPackage.Item_Casket;
import LHoH.LHoH;
import LHoH.Location;

public class Location_ForgottenForest extends Location {
	public Location_ForgottenForest() {

		super();
		String inName = "������� ���";
		int inPower = 45;
		double inwinR = 0.4;
		double pLocation_max = 80;
		String imagePath = "loc5";
		double inbonus50Gold = (double) 0.17 / 60;
		double inbonus50Soul = (double) 0.06 / 60;
		double inbonus50Tear = 0;
		double inbonusALLexp = (double) 1.2 / 60;
		
		
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
		LHoH.gameScreen.itemStock.allScope.add(new Item_Casket(0));
		LHoH.gameScreen.bottomInfo.chat.addTextChat("� ������� ���� �� ����� �������� ��������");
	}
}
