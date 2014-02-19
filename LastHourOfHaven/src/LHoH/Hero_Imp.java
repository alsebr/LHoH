package LHoH;

import java.awt.Image;

public class Hero_Imp extends Hero {
	public Hero_Imp(String name, double power, double exp, double ttl,
			String classH, int zoneId, Image inImage, double inDeltaExp,
			double inDeltaPower) {
		super(name, power, exp, ttl, classH, zoneId, inImage, inDeltaExp,
				inDeltaPower);
		// TODO Auto-generated constructor stub
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
		
		String htmltext=super.getStatusTip();
		double tmppower = 0;
		if (LHoH.gameScreen.itemStock.checkItemCount("�������� ���") > 0) {
			tmppower += getHeroStat().intp;
		}
		
		htmltext+="������ ����: +"+tmppower;
		
		return htmltext;
	}
	
	@Override
	public String getHeroTip() {
		// TODO Auto-generated method stub
		String htmltext;//=super.getHeroTip();
	
		htmltext="������ ����.";
		htmltext+="<br> ����� ��� �������� ������� ����������� ���� ������ �� <b>Int</b>";
		
		return htmltext;
	}
	
}
