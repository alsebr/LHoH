package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hero_Imp extends Hero {
	public Hero_Imp() {

		super();
		//init("���", 25, 1, 60, "", 1, null, 10, 4);

	}

	@Override
	public double getBonusPower() {
		// TODO Auto-generated method stub
		double tmppower = 0;

		if (LHoH.gameScreen.itemStock.checkItemCount("�������� ���") > 0) {
			tmppower += getHeroStat().intp;
		}

		return tmppower;
	}

	@Override
	public String getStatusTip() {
		// TODO Auto-generated method stub

		String htmltext = super.getStatusTip();
		double tmppower = 0;
		if (LHoH.gameScreen.itemStock.checkItemCount("�������� ���") > 0) {
			tmppower += getHeroStat().intp;
		}

		htmltext += "������ ����: +" + tmppower;

		return htmltext;
	}

	@Override
	public String getHeroTip() {
		// TODO Auto-generated method stub
		String htmltext;// =super.getHeroTip();

		htmltext = "������ ����.";
		htmltext += "<br> ����� ��� �������� ������� ����������� ���� ������ �� <b>Int</b>";

		return htmltext;
	}

}
