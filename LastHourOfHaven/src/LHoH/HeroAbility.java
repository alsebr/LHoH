package LHoH;

public class HeroAbility {
String name;
int heroId;

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

}
