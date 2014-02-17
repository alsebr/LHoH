package LHoH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ItemStock extends JPanel{
	static List<Item> allScope = new ArrayList<Item>();
	
	public ItemStock() {
		setPreferredSize(new Dimension(500, 500));
		new FlowLayout(FlowLayout.CENTER,1,1);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		allScope.add(new Item());
		allScope.add(new Item());
		allScope.add(new Item());
		
		//add(LHoH.gameScreen.itemStock);
		
	}
	
	public void paintComponent(Graphics g) {
		
		System.out.println("repaint");
	 
		//removeAll();
		Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    reDrow(g);
	}
	
	void reDrow (Graphics g){
		removeAll();
		for (Item	 item : allScope) {
				add(item);

		}

	}
}
