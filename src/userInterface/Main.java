package userInterface;

import javax.swing.SwingUtilities;

public class Main {

	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                UserInterface ui = new UserInterface();
	                ui.setVisible(true);
	            }
	        });
	    }

}
