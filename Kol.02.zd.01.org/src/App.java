import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		
		//Informations.start();
		
		
		//Informations.stop();
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MainFrame();
				
			}
		});
	}

}
