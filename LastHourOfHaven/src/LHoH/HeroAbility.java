package LHoH;

public class HeroAbility {
String name;
int heroId; // if ==-1 all heroes
private double abilityValue1;
private double abilityValue2;
HeroAbility(){
	
}

void init(int heroId,String name){
	this.heroId=heroId;	
	this.name=name;
}

String getAbilityTip(){
	return name;
	
}

void update(){
	
}

void useAbility() {
	}

void useAbilityForHeroId(int id) {
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

}
