package LHoH;

import javax.swing.text.GapContent;







public class LHoH {
	static MainMenu mainMenu;
	static GameScreen gameScreen;
	LHoH (){
		mainMenu= new MainMenu();
		gameScreen=new GameScreen();
		gameScreen.initiate();
	}
	public static void main(String[] args) {
		LHoH app = new LHoH();
		setFormActiveGameScreen();
	    
	}
	static void setFormActiveMainMenu(){
		mainMenu.setVisible(true);
		gameScreen.setVisible(false);
	}
	static void setFormActiveGameScreen(){
		gameScreen.setVisible(true);
		mainMenu.setVisible(false);
		
	}
	
	
}
