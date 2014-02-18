package LHoH;

import java.awt.Image;

public class Location_imp extends Location{
	Location_imp(String inName,int inPower, double inwinR, Image inEnemy,double inbonus50Gold,double inbonus50Soul, double inbonus50Tear, double inbonusALLexp){
		super(inName,inPower,inwinR,inEnemy,(double)0.2/60,0,0,inbonusALLexp);
	}
	                                         
	@Override
	void modifyIncome() {
		
	if (hero1.getHeroName()=="»ÏÔ"){
		bonus50Gold_final=bonus50Gold*2;
		bonus50Soul_final=bonus50Soul+(double)0.09/60;
		bonus50Tear_final=bonus50Tear;
		bonusALLexp_final=bonusALLexp*2;
		
	}
	else{
		bonus50Gold_final=bonus50Gold;
		bonus50Soul_final=bonus50Soul;
		bonus50Tear_final=bonus50Tear;
		bonusALLexp_final=bonusALLexp;
		
	}
		
	}
}
