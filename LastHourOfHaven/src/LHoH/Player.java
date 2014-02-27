package LHoH;

public class Player {
double gold, soul,tear,ttl;
public double getSoul() {
	return soul;
}

int maxPortal;
private int locationAddCostGold;
int locationActiveNumber;

private double heroNewTier=1;
private double locationNewTier=1;

int[] towerProgress;
Player (){
	gold=3;
	soul=0;
	tear=0;
	ttl=15*60;
	maxPortal=4;
	setLocationAddCostGold(10);
	locationActiveNumber=0;
	
	
	towerProgress=new int[] {0,0,0,0,0,0,-1,-1,-1,-1};
	//towerProgress=new int[] {100,100,100,100,100,-1,-1,-1};
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

public double getTotalTowerProgress(){
	double tmpcount=0;
	for (int i = 0; i < towerProgress.length; i++) {
		if((towerProgress[i])!=-1) tmpcount+=towerProgress[i];
	}
	return tmpcount;
	
}


void update (){
	ttl-=0.017;
	addHeroNewTier(0.005);
	addLocationNewTier(0.005);
	//gold+=0.01;
	
	setLocationAddCostGold(LHoH.gameScreen.locationScope.getNumberAliveLocation()*4);
	
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
	return getTotalTowerProgress();//heroNewTier;
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

public int getLocationAddCostGold() {
	return locationAddCostGold;
}

public void setLocationAddCostGold(int locationAddCostGold) {
	this.locationAddCostGold = locationAddCostGold;
}





}
