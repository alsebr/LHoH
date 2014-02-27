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

public class Location extends JPanel {

	class EnemyIco extends JPanel {
		Image image;
		double power;
		double pLocation;

		public EnemyIco(Image image, double power) {
			this.power = power;
			this.image = image;
			setSize(80, 105);
			setPreferredSize(new Dimension(80, 105));
			setLayout(new GridBagLayout());
			setBorder(BorderFactory.createLineBorder(Color.black));
		}

		public void paintComponent(Graphics g) {

			g.drawImage(image, 1, 1, null);
			g.setColor(Color.red);
			g.setFont(new Font("Arial", Font.BOLD, 16));
			g.drawString(Integer.toString((int)power), 10, 100);
			
			g.drawString(Integer.toString((int)pLocation)+"%", 10, 20);
		}
	}

	BattleZone hero1;
	BattleZone hero2;
	EnemyIco enemyIco;
	double power;
	double winR;
	int status; // 1- live 3 -end

	double pLocation_current=0;
	double pLocation_max=4;
	
	double bonus50Gold = 0;
	double bonus50Soul = 0;
	double bonus50Tear = 0;
	double bonusALLexp = 0;

	private double bonus50Gold_modify = 0;
	private double bonus50Soul_modify = 0;
	private double bonus50Tear_modify = 0;
	private double bonusALLexp_modify = 0;
	
	
	
	
	public double getBonus50Gold_modify() {
		return bonus50Gold_modify;
	}

	public void setBonus50Gold_modify(double bonus50Gold_modify) {
		this.bonus50Gold_modify = bonus50Gold_modify;
	}
	
	public void addBonus50Gold_modify(double bonus50Gold_modify) {
		this.bonus50Gold_modify += bonus50Gold_modify;
	}	

	public double getBonus50Soul_modify() {
		return bonus50Soul_modify;
	}

	public void setBonus50Soul_modify(double bonus50Soul_modify) {
		this.bonus50Soul_modify = bonus50Soul_modify;
	}
	public void addBonus50Soul_modify(double bonus50Soul_modify) {
		this.bonus50Soul_modify += bonus50Soul_modify;
	}

	public double getBonus50Tear_modify() {
		return bonus50Tear_modify;
	}

	public void setBonus50Tear_modify(double bonus50Tear_modify) {
		this.bonus50Tear_modify = bonus50Tear_modify;
	}
	public void addBonus50Tear_modify(double bonus50Tear_modify) {
		this.bonus50Tear_modify += bonus50Tear_modify;
	}

	public double getBonusALLexp_modify() {
		return bonusALLexp_modify;
	}

	public void setBonusALLexp_modify(double bonusALLexp_modify) {
		this.bonusALLexp_modify = bonusALLexp_modify;
	}
	
	public void addBonusALLexp_modify(double bonusALLexp_modify) {
		this.bonusALLexp_modify += bonusALLexp_modify;
	}

	double bonus50Gold_final = 0;
	double bonus50Soul_final = 0;
	double bonus50Tear_final = 0;
	double bonusALLexp_final = 0;

	private String locationName;

	Image imageGold, imageSoul, imageTear;

	protected Location() {

	}
	
	public void decPower(double dPower){
		power-=dPower;
		if (power<1)power=1;
	}
	
	
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	protected void init(String inName, int inPower, double inwinR, Image inEnemy,
			double inbonus50Gold, double inbonus50Soul, double inbonus50Tear,
			double inbonusALLexp,double pLocation_max){

		try {
			imageGold = ImageIO.read(new File("data/image/interface/1_30.gif"));
			imageSoul = ImageIO.read(new File("data/image/interface/3_30.gif"));
			imageTear = ImageIO.read(new File("data/image/interface/2_30.gif"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// setSize(300,300);
		setPreferredSize(new Dimension(400, 110));
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.red));

		status = 1; 

		power = inPower;
		winR = inwinR;
		locationName = inName;

		bonus50Gold = inbonus50Gold;
		bonus50Soul = inbonus50Soul;
		bonus50Tear = inbonus50Tear;
		bonusALLexp = inbonusALLexp;

		
		this.pLocation_max=pLocation_max;
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;

		add(hero1 = new BattleZone(), c);
		hero1.setBounds(2, 2, hero1.getWidth(), hero1.getHeight());

		// add(hero2=new BattleZone());
		// add(new BattleZone());

		enemyIco = new EnemyIco(inEnemy, power);

		enemyIco.setBounds(310, 2, enemyIco.getWidth(), enemyIco.getHeight());
		add(enemyIco);
	}

	void reDrow(Graphics g) {
		// removeAll();

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		Dimension d = getSize();
		Color clr = Color.green;

		// int x = 20;
		// int y = 30;
		// draw Line2D.Double

		// g2.setColor(Color.red);
		g.setColor(new Color(255, 1, 1, 128));
		// g2 = Color.green;
		int xd = 108;
		int x1 = (int) (d.getWidth() / 2 - xd), x2 = (int) (d.getWidth() / 2 + xd);

		g2.fillRect(x1, 1, (int) (2 * xd * winR), (int) (d.getHeight()));

		g.setColor(new Color(155, 1, 1, 128));
		// g2.setColor(Color.LIGHT_GRAY);
		g2.fillRect(x1 + (int) (2 * xd * winR), 1, (int) (xd * 2 * (1 - winR)),
				(int) (d.getHeight()));
		// g2.drawString("Line2D", x, 100);

		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(2));
		g2.draw(new Line2D.Double(d.getWidth() / 2, 19, d.getWidth() / 2, d
				.getHeight() - 19));
		
		
		g2.draw(new Line2D.Double(d.getWidth()/2 +xd/2, 29, d.getWidth()/2+xd/2, d
				.getHeight() - 29));
		

		g2.draw(new Line2D.Double(x1, 19, x1, (int) (d.getHeight() - 19)));
		g2.draw(new Line2D.Double(x2, 19, x2, (int) (d.getHeight() - 19)));

		g2.setFont(new Font("Arial", Font.BOLD, 14));
		g2.drawString(locationName, 115, 15);

		g2.setFont(new Font("Arial", Font.BOLD, 18));
		g2.setColor(Color.black);

		if (winR > 0.5) {
			if (bonus50Gold_final > 0) {
				//
				g2.drawImage(imageGold, (int) (d.getWidth() / 2 + 2), 12, null);
				g2.drawString(String.format("%.2g%n", bonus50Gold_final * 60),
						(int) (d.getWidth() / 2 + 35), 32);
			}
			if (bonus50Soul_final > 0) {
				g2.drawImage(imageSoul, (int) (d.getWidth() / 2 + 2), 43, null);
				g2.drawString(String.format("%.2g%n", bonus50Soul_final * 60),
						(int) (d.getWidth() / 2 + 35), 62);
			}
			if (bonus50Tear_final > 0) {
				g2.drawImage(imageTear, (int) (d.getWidth() / 2 + 2), 74, null);
				g2.drawString(String.format("%.2g%n", bonus50Tear_final * 60),
						(int) (d.getWidth() / 2 + 35), 92);
			}
		}

		if (status == 3) {

			g2.setColor(new Color(50, 50, 50, 188));
			// g2.setColor(Color.LIGHT_GRAY);
			g2.fillRect(1, 1, ((int) (d.getWidth())), (int) (d.getHeight()));
			g2.setColor(Color.black);
			g2.setFont(new Font("Arial", Font.BOLD, 15));
			g2.drawString("ОПУСТОШЕНО", 97, 60);
		}

		add(hero1);

	}

	void modifyIncome() {
		
		//bonus50Gold_final=bonus50Gold+bonus50Gold_modify;
		//bonus50Soul_final=bonus50Soul+bonus50Soul_modify;
		//bonus50Tear_final=bonus50Tear+bonus50Tear_modify;
		//bonusALLexp_final=bonusALLexp+bonusALLexp_modify;
		
	}
	
	void resetModifyIncome(){
		bonus50Gold_modify=0;
		bonus50Soul_modify=0;
		bonus50Tear_modify=0;
		bonusALLexp_modify=0;
		System.out.println("LR");
	}

	void update() {
		System.out.println("LU1");
		bonus50Gold_final=bonus50Gold+bonus50Gold_modify;
		bonus50Soul_final=bonus50Soul+bonus50Soul_modify;
		bonus50Tear_final=bonus50Tear+bonus50Tear_modify;
		bonusALLexp_final=bonusALLexp+bonusALLexp_modify;
		System.out.println("LU2");
		if (status == 1) {

			double powerH = hero1.getPower();
			double delta = powerH / power;

			double winRT;

			double speed = 0.0005;

			if (powerH > power) {
				winRT = 0.5+(double)power/powerH;
				if (winRT>1) winRT=1;
				delta = (double) powerH / power;
				
				
				if (winRT>=winR){
					
				}else{
					delta = -1;
				}
					
				
				
				
			}

			if (powerH < power) {
				winRT = (double) powerH / power / 2;

				if (winRT > winR) {
					delta = (double) powerH / power;
				} else {
					delta = -1 * (double) power / powerH;
					if (delta < -3)
						delta = -2;
				}

				if (powerH == 0)
					delta = -2;
			}

			if (powerH == power) {
				winRT = winR;
				delta = 0;
			}

			winR += delta * speed;

			if (winR < 0.)
				winR = 0;
			if (winR > 1) {
				winR = 1;
				// status=2;
				// hero1.setStatus(2);

				// LHoH.gameScreen.bottomInfo.chat.addTextChat(name+" захвачен нами");
			}

			
			double tmpModif=1;
			if (winR>=0.75) tmpModif=1.5;
			if (winR==1) tmpModif=2;
			
			
			if (winR > 0.5) {
				//System.out.println("1+"+bonus50Gold_final);
				LHoH.gameScreen.player.addGold(bonus50Gold_final*tmpModif);
				LHoH.gameScreen.player.addSoul(bonus50Soul_final*tmpModif);
				LHoH.gameScreen.player.addTear(bonus50Tear_final*tmpModif);
				pLocation_current+=(double)1/60*tmpModif;
			}

			hero1.addExp(bonusALLexp_final*tmpModif);

			hero1.removeHeroIfDead();

			
			enemyIco.power=power;
			enemyIco.pLocation=100/(double)pLocation_max*((double)pLocation_max-(double)pLocation_current);
			
			if (pLocation_current>=pLocation_max) {
				status=3;
				doLocationDevastated();
				LHoH.gameScreen.bottomInfo.chat.addTextChat("Портал "+locationName+" опустошен ");
			}
		}
		if (status == 2) {
			LHoH.gameScreen.player.addGold(bonus50Gold_final);
			LHoH.gameScreen.player.addSoul(bonus50Soul_final);
			LHoH.gameScreen.player.addTear(bonus50Tear_final);
		}
		
		if (status == 3) {
			hero1.removeHeroFromZoneToHome();
		}
		
		resetModifyIncome();
		
		
		
		
	}

	protected void doLocationDevastated(){
		
	}
	
	public void paintComponent(Graphics g) {

		System.out.println("repaint");

		// removeAll();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		reDrow(g);
	}

}
