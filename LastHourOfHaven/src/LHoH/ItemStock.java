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

import ItemPackage.Item_BrokenClock;
import ItemPackage.Item_Plague;
import ItemPackage.Item_PowerUp;
import ItemPackage.Item_chest;

public class ItemStock extends JPanel {
	public static List<Item> allScope = new ArrayList<Item>();

	public ItemStock() {
		setPreferredSize(new Dimension(700, 450));
		new FlowLayout(FlowLayout.CENTER, 3, 3);
		setSize(700, 450);
		// setBorder(BorderFactory.createLineBorder(Color.red));

		allScope.add(new Item_chest(0));
		allScope.add(new Item_BrokenClock(1));

		allScope.add(new Item_PowerUp(0));

		allScope.add(new Item_Plague(0));

		// allScope.add(new Item_LegionGorn());
		// allScope.add(new Item_TaroDemolog());

		setOpaque(false);
		// add(LHoH.gameScreen.itemStock);

	}

	public void paintComponent(Graphics g) {

		System.out.println("repaint");

		// removeAll();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		reDrow(g);
	}

	void update() {

		List<Item> tmpScope = new ArrayList<Item>();
		
		for (Item item : allScope) {
			if (item.isFlagRemoveThisTick()) {
				tmpScope.add(item);
				
			}
			
		}

		for (Item item : tmpScope) {
				allScope.remove(item);
		}
		
		
		
		for (Item item : allScope) {
			item.update();

		}

	}

	void reDrow(Graphics g) {
		revalidate();
		removeAll();
		for (Item item : allScope) {
			add(item);

		}

	}

	boolean getItem(String nameItem) {
		for (Item item : allScope) {
			if (item.getName() == nameItem) {
				allScope.remove(item);
				return true;
			}
		}
		return false;
	}

	public int checkItemCount(String nameItem) {
		int count = 0;
		for (Item item : allScope) {
			if (item.getName() == nameItem) {
				count++;

			}
		}
		return count;
	}

}
