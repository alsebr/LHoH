package LHoH;

import java.awt.Image;

import ItemPackage.Item_Casket;

public class Boss {
	double powerStart;
	private double powerCurrent;
	private Image imageBoss;
	private String nameBoss;
	private String tipBoss;
	double inWR;
	double inTTL;
	private double TTL;
	private double wR;
	private boolean flagTimeEnd = false;
	private double heroPower = 0;
	private double heroPower_pure = 0;
	private double heroPower_bonus = 0;
	private int status = 0; // 1- live 2- ended  3 - win
	private int lvlTower;
	boolean flagGet25ThisTime=false;
	boolean flagGet50ThisTime=false;
	boolean flagGet75ThisTime=false;
	boolean flagGet100ThisTime=false;
	protected Boss() {

	}

	public void init(double powerStart, Image imageBoss, String nameBoss,
			String tipBoss, double inWR, double inTTL, int lvlTower) {
		this.powerStart = powerStart;
		this.setImageBoss(imageBoss);
		this.setNameBoss(nameBoss);
		this.setTipBoss(tipBoss);
		this.inWR = inWR;
		this.inTTL = inTTL;

		this.TTL = this.inTTL;
		this.setwR(this.inWR);
		this.powerCurrent = this.powerStart;

		this.lvlTower = lvlTower;

		setStatus(1);
	}

	public boolean isLive() {
		if (status == 1) return true;
		return false;
	}

	void setStatusTimeEnd() {
		status = 2;
	}
	
	void setStatusWin() {
		status = 3;
	}

	public void useSpecialAbility(){
		
	}
	
	void resetTick(){
		heroPower_bonus=0;
	}
	
	void updateBoss() {
		if (isLive()) {
			resetTick();
			double powerH = 0;
			for (Hero hero : LHoH.gameScreen.heroStock.allScope) {
				if ((hero.getZone() == 1) && (hero.status == 1)) {
					powerH += hero.getPower();
				}
			}

			setHeroPower_pure(powerH);
			
			LHoH.gameScreen.heroAbilityStock.useAllAbilityBoss();
			
			useSpecialAbility();
			
			powerH+=heroPower_bonus;
			
			setHeroPower(powerH);


			
			TTL -= (double) 1 / 60;
			if (TTL <= 0)
				setStatusTimeEnd();

			double power = getPowerCurrent();
			double speed = 0.0005;
			double delta = 0;
			delta = (double) getHeroPower() / power;

			if ((wR >= 0.25) && (!flagGet25ThisTime)) {
				check25Prize();
				flagGet25ThisTime=true;

			}
			if ((wR >= 0.50) && (!flagGet50ThisTime)) {
				check50Prize();
				flagGet50ThisTime=true;
			}
			if ((wR >= 0.75) && (!flagGet75ThisTime)) {
				check75Prize();
				flagGet75ThisTime=true;
			}
			
			
			
			setwR(getwR() + delta * speed);
			
			if (wR >= 1) {
				if (!flagGet100ThisTime) {
				check100Prize();
				flagGet100ThisTime=true;
				}
				
				wR = 1;
				setStatusWin();

			}
		}
	}

	public void checkPrize() {

	}

	public Image getImageBoss() {
		return imageBoss;
	}

	public void setImageBoss(Image imageBoss) {
		this.imageBoss = imageBoss;
	}

	public double getPowerCurrent() {
		return powerCurrent;
	}

	public void setPowerCurrent(double powerCurrent) {
		this.powerCurrent = powerCurrent;
	}

	public double getTTL() {
		return TTL;
	}

	public void setTTL(double tTL) {
		TTL = tTL;
	}

	public String getNameBoss() {
		return nameBoss;
	}

	public void setNameBoss(String nameBoss) {
		this.nameBoss = nameBoss;
	}

	public String getTipBoss() {
		return tipBoss;
	}

	public void setTipBoss(String tipBoss) {
		this.tipBoss = tipBoss;
	}

	public void get25PrizeFirst() {

	}

	public void get25PrizeAlwayse() {

	}	
	
	public void get50PrizeFirst() {

	}

	public void get50PrizeAlwayse() {

	}
	
	public void get75PrizeFirst() {

	}

	public void get75PrizeAlwayse() {

	}
	
	public void get100PrizeFirst() {

	}

	public void get100PrizeAlwayse() {

	}
	
	public void check25Prize() {
		
		LHoH.gameScreen.bottomInfo.chat
		.addTextChat(getNameBoss()+" повержен вами на 25%");
		
		if (LHoH.gameScreen.player.getTowerProgress(getLvlTower()) < 25) {
			get25PrizeFirst();
		} 
		get25PrizeAlwayse();
	}

	public void check50Prize() {
		LHoH.gameScreen.bottomInfo.chat
		.addTextChat(getNameBoss()+" повержен вами на 50%");
		
		if (LHoH.gameScreen.player.getTowerProgress(getLvlTower()) < 50) {
			get50PrizeFirst();
		} 
		get50PrizeAlwayse();
	}

	public void check75Prize() {
		LHoH.gameScreen.bottomInfo.chat
		.addTextChat(getNameBoss()+" повержен вами на 75%");
		
		if (LHoH.gameScreen.player.getTowerProgress(getLvlTower()) < 75) {
			get75PrizeFirst();
		} 
		get75PrizeAlwayse();
	}
	public void check100Prize() {
		LHoH.gameScreen.bottomInfo.chat
		.addTextChat(getNameBoss()+" повержен вами на 100%");
		
		if (LHoH.gameScreen.player.getTowerProgress(getLvlTower())!=100) {
			get100PrizeFirst();
		} 
		get100PrizeAlwayse();
	}


	public boolean isFlagTimeEnd() {
		return flagTimeEnd;
	}

	public void setFlagTimeEnd(boolean flagTimeEnd) {
		this.flagTimeEnd = flagTimeEnd;
	}

	public double getwR() {
		return wR;
	}

	public void setwR(double wR) {
		this.wR = wR;
	}

	public double getHeroPower() {
		return heroPower;
	}

	public void setHeroPower(double heroPower) {
		this.heroPower = heroPower;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getLvlTower() {
		return lvlTower;
	}

	public void setLvlTower(int lvlTower) {
		this.lvlTower = lvlTower;
	}

	public void addPowerCurrent(double value){
		powerCurrent+=value;
	}



	public void addHeroPower_bonus(double heroPower_bonus) {
		this.heroPower_bonus += heroPower_bonus;
	}

	public double getHeroPower_bonus() {
		return heroPower_bonus;
	}
	
	public double getHeroPower_pure() {
		return heroPower_pure;
	}

	public void setHeroPower_pure(double heroPower_pure) {
		this.heroPower_pure = heroPower_pure;
	}
	
}
