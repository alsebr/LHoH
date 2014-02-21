package LHoH;

public class HeroAbility {
String name;
int heroId; // if ==-1 all heroes

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

}
