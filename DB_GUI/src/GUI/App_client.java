package GUI;

import javax.swing.SwingUtilities;

public class App_client {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				new AplicationFrame();

			}
		});
	}

}
