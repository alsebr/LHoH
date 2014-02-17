package LHoH;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Item extends JPanel{
	int id;
	public Item() {
		setSize(80	,105);
		setPreferredSize(new Dimension(80,105));
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		Random randomGenerator = new Random();
	    id=randomGenerator.nextInt(32000);
	}

}
