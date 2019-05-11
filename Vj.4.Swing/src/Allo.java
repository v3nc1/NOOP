import javax.swing.JButton;
import javax.swing.JFrame;

public class Allo extends JFrame {


	public static void main(String[] args) {
		
		JFrame myWindow = new Allo();
		
		JButton myButton = new JButton("Click me");
		
		myWindow.add(myButton);
		myWindow.setSize(600, 300);
		myWindow.setTitle("Aplikacija za ništa");
		myWindow.setVisible(true);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}

}
