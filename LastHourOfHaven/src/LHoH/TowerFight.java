package LHoH;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import HeroAbilitisPackage.HeroAbility_HowlOfTheWolf;
import ItemPackage.Item_Casket;
import ItemPackage.Item_Key1;
import ItemPackage.Item_Key2;
import ItemPackage.Item_LegionGorn;
import ItemPackage.Item_Plague;
import ItemPackage.Item_PowerUp;
import ItemPackage.Item_Soul;
import ItemPackage.Item_chest;
import ItemPackage.Item_lamp;

public class TowerFight extends JPanel {
	Image bckground = null;
	private int lvlTower;
	private Boss boss;
	public double bossPower;
	String bossName;
	double winR;
	double powerH = 0;
	int status = 0; // 0 - nohere, 1 - battle, 2- win
	double ttl;
	JLabel bossTipJLabel;
	JButton endTower;

	public TowerFight() {
		setSize(700, 450);
		setLayout(null);
		setOpaque(false);
		// setBorder(BorderFactory.createLineBorder(Color.green));
		endTower = new JButton();
		String tmptext;

		tmptext = "Окончить бой";

		endTower.setBounds(550, 400, 121, 30);
		endTower.setOpaque(false);
		endTower.setText(tmptext);

		endTower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endTowerBattle();
			}
		});

		bossTipJLabel = new JLabel();
		bossTipJLabel.setBounds(330, 35, 250, 200);
		bossTipJLabel.setOpaque(false);

		add(bossTipJLabel);
		// revalidate();

	}

	void endTowerBattle() {
		LHoH.gameScreen.bottomInfo.chat
				.addTextChat("Вы покидаете Бесконечную башню");
		LHoH.gameScreen.player.setTowerProgress(boss.getLvlTower(),
				boss.getwR());
		status = 0;
		LHoH.gameScreen.towerPanel.activateTowerChoizeScreen();
	}

	void update() {

		if (status == 1) {

			boss.updateBoss();

			LHoH.gameScreen.player.setTowerProgress(boss.getLvlTower(),
					boss.getwR());
		}

	}

	void init(Boss inBoss) {

		boss = inBoss;
		addComp();

		String tmptext = "<html><p><font color=red>";
		tmptext += boss.getTipBoss();
		tmptext += "</font></p>";
		bossTipJLabel.setText(tmptext);

		status = 1;

	}

	void addComp() {
		removeAll();
		add(LHoH.gameScreen.heroStockScroll);
		add(endTower);
		add(bossTipJLabel);
	}

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(new Color(255, 1, 1, 77));
		g.drawImage(boss.getImageBoss(), 0, 0, null);

		g2.fillRect(0, (int) (450 * (1 - boss.getwR())), 700,
				(int) (450 * (boss.getwR())));

		g.setColor(Color.red);
		g2.setFont(new Font("Arial", Font.BOLD, 22));
		g2.drawString(boss.getNameBoss(), 290, 30);

		g.setColor(Color.red);
		g2.setFont(new Font("Arial", Font.BOLD, 30));

		g2.drawString(
				"Мощь: " + Integer.toString((int) boss.getPowerCurrent()), 470,
				65);

		g2.drawString(Integer.toString((int) boss.getHeroPower_pure()) + "+"
				+ Integer.toString((int) boss.getHeroPower_bonus()), 110, 425);

		g2.drawString("Время: " + FrameWorkLHoH.ttlToTime(boss.getTTL()), 470,
				95);

		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(2));
		for (int i = 0; i < 4; i++) {
			g2.setStroke(new BasicStroke(2));
			if (i == 2)
				g2.setStroke(new BasicStroke(4));
			g2.draw(new Line2D.Double(670, getHeight() / 4 * i, 700,
					getHeight() / 4 * i));
		}

	}

	public Boss getBoss() {
		return boss;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	public int getLvlTower() {
		return lvlTower;
	}

	public void setLvlTower(int lvlTower) {
		this.lvlTower = lvlTower;
	}

}
