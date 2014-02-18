package LHoH;

public class Player {
double gold, soul,tear,ttl;
int maxPortal;
int locationAddCostGold;
int locationActiveNumber;
Player (){
	gold=3;
	soul=0;
	tear=0;
	ttl=15*60;
	maxPortal=3;
	locationAddCostGold=10;
	locationActiveNumber=0;
}

void update (){
	ttl-=0.017;
	//gold+=0.01;
	
	locationAddCostGold=10*LHoH.gameScreen.locationScope.allScope.size();
	
	locationActiveNumber=0;
	for (Location location : LHoH.gameScreen.locationScope.allScope) {
		if (location.status==1) locationActiveNumber++;
	}
}



void addGold(double dGold){
	gold+=dGold;
}

void addSoul(double dSoul){
	soul+=dSoul;
}
void addTear(double dTear){
	tear+=dTear;
}

boolean takeResurs(double dGold,double dSoul, double dTear){
	if ((dGold<=gold)&&(dSoul<=soul)&&(dTear<=tear)){
		gold-=dGold;
		soul-=dSoul;
		tear-=dTear;
		return true;
	}
	
	return false;
}

}
