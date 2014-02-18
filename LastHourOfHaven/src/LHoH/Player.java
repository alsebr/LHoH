package LHoH;

public class Player {
double gold, soul,tear,ttl;
int maxPortal;
int locationAddCostGold;
int locationActiveNumber;
int[] towerProgress;
Player (){
	gold=3;
	soul=0;
	tear=0;
	ttl=15*60;
	maxPortal=4;
	locationAddCostGold=10;
	locationActiveNumber=0;
	
	
	towerProgress=new int[] {0,0,-1,-1,-1,-1,-1,-1};
}

void setTowerProgress(int inLvl,double proc){
	
	int procInt=(int)(proc*100);
	
	if (towerProgress[inLvl]<procInt){
		towerProgress[inLvl]=procInt;
		if ((towerProgress[inLvl+1]==-1)&&(procInt>=25)){
			towerProgress[inLvl+1]=0;
		}
	}
	
}


void update (){
	ttl-=0.017;
	//gold+=0.01;
	
	locationAddCostGold=4*LHoH.gameScreen.locationScope.allScope.size();
	
	locationActiveNumber=0;
	for (Location location : LHoH.gameScreen.locationScope.allScope) {
		if (location.status==1) locationActiveNumber++;
	}
}

int getTowerLvlProgress(int lvlTower){
	return towerProgress[lvlTower];
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
