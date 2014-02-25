package LHoH;

public class Player {
double gold, soul,tear,ttl;
int maxPortal;
int locationAddCostGold;
int locationActiveNumber;

private double heroNewTier=1;
private double locationNewTier=1;

int[] towerProgress;
Player (){
	gold=111113;
	soul=1110;
	tear=11110;
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

public double getTowerProgress(int inLvl){
	
	return (towerProgress[inLvl]);
	
}


void update (){
	ttl-=0.017;
	addHeroNewTier(0.005);
	addLocationNewTier(0.005);
	//gold+=0.01;
	
	locationAddCostGold=4*LHoH.gameScreen.locationScope.getNumberAliveLocation();
	
	locationActiveNumber=0;
	for (Location location : LHoH.gameScreen.locationScope.allScope) {
		if (location.status==1) locationActiveNumber++;
	}
}

int getTowerLvlProgress(int lvlTower){
	return towerProgress[lvlTower];
}




public void addGold(double dGold){
	gold+=dGold;
}

public void addSoul(double dSoul){
	soul+=dSoul;
}
public void addTear(double dTear){
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

public double getHeroNewTier() {
	return heroNewTier;
}

public void addHeroNewTier(double heroNewTier) {
	this.heroNewTier += heroNewTier;
}

public double getLocationNewTier() {
	return locationNewTier;
}

public void addLocationNewTier(double locationNewTier) {
	this.locationNewTier += locationNewTier;
}



}
