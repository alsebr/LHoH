package LHoH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Item_PowerUp extends Item{
public Item_PowerUp() {
super();
try {
	image = ImageIO.read(new File("data/image/item/item12.gif"));
} catch (IOException e) {
}

setToolTipText("Усиливает ваше существо");
}

void activateItem(){
	String tmpText;
	int addGold,addSoul;
	
	Hero tmp=null;
	
	for (Hero hero : HeroStock.allScope) {
		if (hero.status==1)	{
			tmp=hero;
		}
	}
	if (tmp!=null){
		
		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_Imp(getId()));
		tmpText=tmp.name+ " Был отмечен печатью Великого! (+25 мощи)";
		//tmp.addPower(25);
		LHoH.gameScreen.heroAbilityStock.addAbility(new HeroAbility_DemonicSignet(tmp.getId()));
		LHoH.gameScreen.bottomInfo.chat.addTextChat(tmpText);

		
		
		SelfDestroy();	
	}
	
}

}
