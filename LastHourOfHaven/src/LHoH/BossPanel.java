package LHoH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class BossPanel extends JPanel{
Image imageBoss1;
double bossPower=300;
String bossName="Тираэль — архангел Высоких Небес";
double winR;
double powerH=0;
//Location bosLocation=new Location();

	public BossPanel() {
	setSize(700,450);
	setPreferredSize(new Dimension(50, 104));
	setLayout(null);
	setBorder(BorderFactory.createLineBorder(Color.black));
	
	try {
		imageBoss1 = ImageIO.read(new File("data/image/bos/bos1.gif"));
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	addComp();
	
	winR=0.5;
}

public void paintComponent(Graphics g) {
	
	
	Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    
    g.setColor(new Color(255,1,1,128));
    g.drawImage(imageBoss1, 0, 0, null);

    
    g2.fillRect(0, (int)(450*(1-winR)),700 ,(int)(450*(winR)));
    
    g.setColor(Color.black);
    g2.setFont(new Font("Arial", Font.BOLD, 20)); 
	
		
	
		g2.drawString(bossName, 290, 30);
	
		
		g.setColor(Color.red);
		g2.setFont(new Font("Arial", Font.BOLD, 30)); 
		
		g2.drawString(Integer.toString((int)bossPower), 530, 65);
		
		
		g2.drawString(Integer.toString((int)powerH), 110, 425);
    
}
void addComp(){
removeAll();
add (LHoH.gameScreen.heroStockScroll);
//add(bosLocation);

}

void update (){
	
	powerH=0;
	/*
	for (Hero hero : LHoH.gameScreen.heroStock.allScope) {
		if (hero.getZone()==1)	{
			powerH+=hero.getPower();
		}
	}
	*/
	double winRT;
	double power=bossPower;
	double speed=0.0005;
	double delta=0;
	
	if (powerH>power){
		winRT=1;
		delta=(double)powerH/power;
	}
	
	if (powerH<power){
		winRT=(double)powerH/power/2;
		
		if( winRT>winR){
			delta= (double)powerH/power;
		}
		else{
			delta=-1*(double)power/powerH;
			if (delta<-3) delta=-0.5;
		}
			
		
		if (powerH==0) delta=-0.5;
	}
	
	if (powerH==power) {
		winRT=winR;
		delta=0;
	}
	
	winR+=delta*speed;
	
	if (winR<0.) winR=0;
	if (winR>=1) {
		winR=1;
		//status=2;
		//hero1.setStatus(2);
		winR=0.7;
		bossPower=6666;
		bossName="Рафаэль";
		try {
			imageBoss1 = ImageIO.read(new File("data/image/bos/bos2.gif"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LHoH.gameScreen.bottomInfo.chat.addTextChat("Нами повержен Тираэль — архангел Высоких Небес");
	}
	
	bossPower+=(double)2/60;
}

}
