package LHoH;

import java.awt.Image;

public class LocationRaid extends Location{
	LocationRaid(String inName,int inPower, double inwinR, Image inEnemy,double inbonus50Gold,double inbonus50Soul, double inbonus50Tear, double inbonusALLexp){
		super(inName,inPower,inwinR,inEnemy,0,0,0,inbonusALLexp);
	}
	                                         
	void update (){
		if (status==1){
			
		
			double powerH=hero1.getPower();
			double delta= powerH/power;
			
			double winRT;
			
			double speed=0.0002;
			

			
			
			
			winR+=delta*speed;
			
			if (winR<0.) winR=0;
			if (winR>1) {
				winR=1;
				//status=2;
				//hero1.setStatus(2);
				
				//LHoH.gameScreen.bottomInfo.chat.addTextChat(name+" захвачен нами");
			}
			
			
			if (winR>0.5) {
				LHoH.gameScreen.player.addGold(bonus50Gold);
				LHoH.gameScreen.player.addSoul(bonus50Soul);
				LHoH.gameScreen.player.addTear(bonus50Tear);
			}
			
			hero1.addExp(bonusALLexp);
			
			hero1.removeHeroIfDead();
			
		}
		if (status==2){
			LHoH.gameScreen.player.addGold(bonus50Gold);
			LHoH.gameScreen.player.addSoul(bonus50Soul);
			LHoH.gameScreen.player.addTear(bonus50Tear);
		}
	}
}
