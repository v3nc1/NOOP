import java.util.Scanner;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Mainframe();
				
			}
		});
		/*
		Scanner scan = new Scanner(System.in);

		
		
		
			System.out.println("Unesi prvi broj: ");
			a = scan.nextFloat();

			System.out.println("Unesi operater: ");
			operator = scan.next();

			System.out.println("Unesi drugi broj: ");
			b = scan.nextFloat();

			*/
		

	}

}
