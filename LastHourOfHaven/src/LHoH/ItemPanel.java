package LHoH;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ItemPanel extends JPanel {
	ItemPanel() {
		setSize(700, 450);
		
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		add(LHoH.gameScreen.itemStock);
	}
}
