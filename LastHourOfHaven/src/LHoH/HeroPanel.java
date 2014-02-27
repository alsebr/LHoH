package LHoH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeroPanel extends JPanel {
	Image bckground = null;
	JButton updateTaverna = new JButton();
	JLabel updateHeroInfo = new JLabel();

	public HeroPanel() {
		// setSize(700,450);
		setSize(700, 450);
		setPreferredSize(new Dimension(50, 104));
		setLayout(new FlowLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));

		updateTaverna.setText("Обновить (4 монеты)");
		updateTaverna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LHoH.gameScreen.player.takeResurs(4, 0, 0)) {
					LHoH.gameScreen.taverna.setFlagToUpdateHeroes(true);
					LHoH.gameScreen.player
							.addHeroNewTier(10 + (double) LHoH.gameScreen.player
									.getHeroNewTier() * 0.03);
				}

			}
		});

		addComp();

		try {
			bckground = ImageIO
					.read(new File("data/image/bckground/portal.gif"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void addComp() {
		removeAll();
		// add (LHoH.gameScreen.heroStock);
		add(LHoH.gameScreen.taverna);
		// updateHeroInfo.setPreferredSize(new Dimension(130, 31));

		add(updateTaverna);
		updateHeroInfo.setOpaque(true);
		;
		add(updateHeroInfo);
		revalidate();

	}

	public void paintComponent(Graphics g) {
		g.drawImage(bckground, 0, 0, null);

	}

	void update() {
		String tmptext = "1";

		String tmptext1 = "";
		double tmptext2 = 0;

		for (int i = 0; i < LHoH.gameScreen.taverna.arrayHeroPlayerLvlNeed.length; i++) {
			if (LHoH.gameScreen.player.getHeroNewTier() >= LHoH.gameScreen.taverna.arrayHeroPlayerLvlNeed[i]) {
				tmptext2 = (int) LHoH.gameScreen.taverna.arrayHeroPlayerLvlNeed[i + 1];
				tmptext1 = LHoH.gameScreen.taverna.arrayHeroPlayerNew[i + 1].name;
			}
		}

		tmptext = "<html> <p align=center><Font color=black>";
		tmptext += "Уровень прогресса бесконечной башни: "
				+ (int) LHoH.gameScreen.player.getHeroNewTier();
		tmptext += "<br>Доступ к " + tmptext1 + " на " + tmptext2 + " уровне";
		updateHeroInfo.setText(tmptext);
	}
}
