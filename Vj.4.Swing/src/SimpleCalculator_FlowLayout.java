import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleCalculator_FlowLayout {

	public static void main(String[] args) {
		
		// Pravi paletu
		
		JPanel windowCont = new JPanel();
		
		//Zadaje upravljaè rasporeda
		
		FlowLayout fl = new FlowLayout();
		windowCont.setLayout(fl);
		
		//Pravi kontrole u memoriji
		
		JLabel label1 = new JLabel("Number 1: ");
		JTextField field1 = new JTextField(10);
		JLabel label2 = new JLabel("Number 2: ");
		JTextField field2 = new JTextField(10);
		JLabel label3 = new JLabel("Sum: ");
		JTextField res = new JTextField(10);
		JButton go = new JButton("Add");
		
		//Dodaje kontrole na paletu
		
		windowCont.add(label1);
		windowCont.add(field1);
		windowCont.add(label2);
		windowCont.add(field2);
		windowCont.add(label3);
		windowCont.add(res);
		windowCont.add(go);
		
		//Pravi novi prozor i dodaje paletu
		
		JFrame frame = new JFrame("Simple Calculator");
		
		//Dodaje paletu u gornji kontejner
		
		frame.setContentPane(windowCont);
		
		//Zadaje velièinu i prikazuje prozor
		
		frame.setSize(700,100);
		frame.setVisible(true);

	}

}
