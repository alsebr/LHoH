package LHoH;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Location extends JPanel{

	class EnemyIco extends JPanel {
		Image image;
		int power;
		
		public EnemyIco(Image image,int power) {
			this.power=power;
			this.image=image;
			setSize(80,105);
			setPreferredSize(new Dimension(80, 105));
			setLayout(new GridBagLayout());
			setBorder(BorderFactory.createLineBorder(Color.black));
		}
		public void paintComponent(Graphics g) {
			
			g.drawImage(image, 1, 1, null);
	        g.setColor(Color.red);
			g.setFont(new Font("Arial", Font.BOLD, 16)); 
			g.drawString(Integer.toString(power), 10, 100);
		}
	}
	
	BattleZone hero1;
	BattleZone hero2;
	EnemyIco enemyIco;
	int power;
	double winR;
	int status; // 1- live 2 -strage
	
	double bonus50Gold;
	double bonus50Soul;
	double bonus50Tear;
	double bonusALLexp;
	String name;
	
	Image imageGold, imageSoul,imageTear;
	
	Location(String inName,int inPower, double inwinR, Image inEnemy,double inbonus50Gold,double inbonus50Soul, double inbonus50Tear, double inbonusALLexp){
		
		try {
			imageGold = ImageIO.read(new File("data/image/interface/1_30.gif"));
			imageSoul = ImageIO.read(new File("data/image/interface/3_30.gif"));
			imageTear = ImageIO.read(new File("data/image/interface/2_30.gif"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//setSize(300,300);
	setPreferredSize(new Dimension(400, 110));
	setLayout(null);
	setBorder(BorderFactory.createLineBorder(Color.red));
	
	status=1;
	
	power=inPower;
	winR=inwinR;
	name=inName;
	
	bonus50Gold=inbonus50Gold;
	bonus50Soul=inbonus50Soul;
	bonus50Tear=inbonus50Tear;
	bonusALLexp=inbonusALLexp;
	
	GridBagConstraints c = new GridBagConstraints();
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 1;
	
	
	add(hero1=new BattleZone(),c);
	hero1.setBounds(2, 2, hero1.getWidth(), hero1.getHeight());
	
	//add(hero2=new BattleZone());
	//add(new BattleZone());

		enemyIco= new EnemyIco(inEnemy,power);

	enemyIco.setBounds(310, 2, enemyIco.getWidth(), enemyIco.getHeight());
	add(enemyIco);
	}
	
	void reDrow(Graphics g){
	//	removeAll();
		
		Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension d = getSize();
        Color clr = Color.green;
 
        //int x = 20;
        //int y = 30;
        // draw Line2D.Double
        
        
        //g2.setColor(Color.red);
        g.setColor(new Color(255,1,1,128));
        //g2 = Color.green;
        int xd=108;
        int x1=(int)(d.getWidth()/2-xd),x2=(int)(d.getWidth()/2+xd);

        
        g2.fillRect(x1, 1,(int) (2*xd*winR),(int) (d.getHeight()));
        
        g.setColor(new Color(155,1,1,128));
        //g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(x1+(int)(2*xd*winR), 1,(int)(xd*2*(1-winR)) ,(int) (d.getHeight()));
        //g2.drawString("Line2D", x, 100);
 
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(2));
        g2.draw(new Line2D.Double(d.getWidth()/2, 19, d.getWidth()/2, d.getHeight()-19));
		
        g2.draw(new Line2D.Double(x1, 19, x1, (int)(d.getHeight()-19)));
        g2.draw(new Line2D.Double(x2, 19, x2, (int)(d.getHeight()-19)));
        
        
        g2.setFont(new Font("Arial", Font.BOLD, 14)); 
		g2.drawString(name, 115, 15);
		
		
		if (winR>0.5){
			if (bonus50Gold>0) g2.drawImage(imageGold, (int)(d.getWidth()/2 + 2), 12, null);
			if (bonus50Soul>0) g2.drawImage(imageSoul, (int)(d.getWidth()/2 + 2), 43, null);
			if (bonus50Tear>0)g2.drawImage(imageTear, (int)(d.getWidth()/2 + 2), 74, null);
		}
		
		if (status==2){
	        

	        g2.setColor(new Color(50,50,50,188));
	        //g2.setColor(Color.LIGHT_GRAY);
	        g2.fillRect(1, 1,((int)(d.getWidth())) ,(int) (d.getHeight()));
	        g2.setColor(Color.black);
			g2.setFont(new Font("Arial", Font.BOLD, 15)); 
			g2.drawString("ÇÀÕÂÀ×ÅÍÎ", 97, 60);
		}
		
		add (hero1);
		

    }
	
	void update (){
		if (status==1){
			
		
			double powerH=hero1.getPower();
			double delta= powerH/power;
			
			double winRT;
			
			double speed=0.0005;
			
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
					if (delta<-3) delta=-2;
				}
					
				
				if (powerH==0) delta=-2;
			}
			
			if (powerH==power) {
				winRT=winR;
				delta=0;
			}
			
			winR+=delta*speed;
			
			if (winR<0.) winR=0;
			if (winR>1) {
				winR=1;
				//status=2;
				//hero1.setStatus(2);
				
				//LHoH.gameScreen.bottomInfo.chat.addTextChat(name+" çàõâà÷åí íàìè");
			}
			
			
			if (winR>0.5) {
				LHoH.gameScreen.player.addGold(bonus50Gold);
				LHoH.gameScreen.player.addSoul(bonus50Soul);
				LHoH.gameScreen.player.addTear(bonus50Tear);
			}
			
			hero1.addExp(bonusALLexp);
			
			hero1.removeHeroIfDead();
			
		}
		if (status==2){
			LHoH.gameScreen.player.addGold(bonus50Gold);
			LHoH.gameScreen.player.addSoul(bonus50Soul);
			LHoH.gameScreen.player.addTear(bonus50Tear);
		}
	}
	
	public void paintComponent(Graphics g) {
		
		System.out.println("repaint");
	 
		//removeAll();
		Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    reDrow(g);
	}
    
	
}

