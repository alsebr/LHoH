package LHoH;

import java.io.ObjectInputStream.GetField;
import java.util.Random;

public class HeroAbility implements Comparable{
String name;
protected int heroId; // if ==-1 all heroes
private double abilityValue1;
private double abilityValue2;
private double abilityValue3;
private double abilityValue4;
private int heroAbilityId;
protected int itemId=0;
private boolean flagRemoveThisTick=false;

private int sequenceNumber=20;  //20-standart          10- stat(first)  30-last



public int getItemId() {
	return itemId;
}

public void setItemId(int itemId) {
	this.itemId = itemId;
}

protected HeroAbility(){
	Random randomGenerator = new Random();
	setHeroAbilityId(randomGenerator.nextInt(32000));
}

protected void init(int heroId,String name){
	this.heroId=heroId;	
	this.name=name;
}

public String getAbilityTip(){
	return name;
	
}

protected void update(){

}

public void useAbility() {
	}

public void useAbilityForHeroId(int id) {
}

public double getAbilityValue1() {
	return abilityValue1;
}

public void setAbilityValue1(double abilityValue1) {
	this.abilityValue1 = abilityValue1;
}

public double getAbilityValue2() {
	return abilityValue2;
}

public void setAbilityValue2(double abilityValue2) {
	this.abilityValue2 = abilityValue2;
}

public void selfDestroy(){
	//for (HeroAbility heroAbility : LHoH.gameScreen.heroAbilityStock.allScope) {
//		if (heroAbility.getHeroAbilityId()==getHeroAbilityId())	{
			//LHoH.gameScreen.itemStock.allScope.remove(heroAbilityId);
//		}
	//}
	
	setFlagRemoveThisTick(true);
}

public int getHeroAbilityId() {
	return heroAbilityId;
}

public void setHeroAbilityId(int heroAbilityId) {
	this.heroAbilityId = heroAbilityId;
}

public boolean isFlagRemoveThisTick() {
	return flagRemoveThisTick;
}

public void setFlagRemoveThisTick(boolean flagRemoveThisTick) {
	this.flagRemoveThisTick = flagRemoveThisTick;
}

public double getAbilityValue3() {
	return abilityValue3;
}

public void setAbilityValue3(double abilityValue3) {
	this.abilityValue3 = abilityValue3;
}

public double getAbilityValue4() {
	return abilityValue4;
}

public void setAbilityValue4(double abilityValue4) {
	this.abilityValue4 = abilityValue4;
}

public int getSequenceNumber() {
	return sequenceNumber;
}

public void setSequenceNumberDefault() {
	this.sequenceNumber = 20;
}

public void setSequenceNumberStatModify() {
	this.sequenceNumber = 10;
}

@Override
public int compareTo(Object arg0) {
	// TODO Auto-generated method stub
	
	if (sequenceNumber>((HeroAbility)arg0).getSequenceNumber()) return 1;
	if (sequenceNumber<((HeroAbility)arg0).getSequenceNumber()) return -1;
	return 0;
}

}
