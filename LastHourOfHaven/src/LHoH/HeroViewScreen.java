package LHoH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HeroViewScreen extends JFrame{
	HeroViewScreen(){
		setSize(250	, 250);
		//setPreferredSize(new Dimension(50, 104));
		setLayout(new FlowLayout());
		setAlwaysOnTop(true);
		setResizable(false);
		//setUndecorated(true);
	}

}
