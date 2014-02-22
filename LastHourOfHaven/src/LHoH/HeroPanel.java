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
import javax.swing.JPanel;

public class HeroPanel extends JPanel {
	Image bckground = null;
	JButton updateTaverna = new JButton();

	public HeroPanel() {
		// setSize(700,450);
		setSize(700, 450);
		setPreferredSize(new Dimension(50, 104));
		setLayout(new FlowLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));

		updateTaverna.setText("Обновить (4 монеты)");
		updateTaverna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LHoH.gameScreen.player.takeResurs(3, 0, 0)) {
					LHoH.gameScreen.taverna.setFlagToUpdateHeroes(true);
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

		add(updateTaverna);
	}

	public void paintComponent(Graphics g) {
		// removeAll();
		// add (LHoH.gameScreen.heroStock);
		// add (LHoH.gameScreen.locationScope);
		g.drawImage(bckground, 0, 0, null);

	}
}
