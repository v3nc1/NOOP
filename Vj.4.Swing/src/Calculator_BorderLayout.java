import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator_BorderLayout {
	
		//Deklariranje svih komponenti kalkulatora
	
		JPanel winCont;
		JTextField txtF;
		JButton button0;
		JButton button1;
		JButton button2;
		JButton button3;
		JButton button4;
		JButton button5;
		JButton button6;
		JButton button7;
		JButton button8;
		JButton button9;
		JButton bttPoint;
		JButton bttEq;
		JPanel p1;
	
		//Konstruktor prve komponente
		//dodaji se u okvir korištenjem kombinacije 
		//Borderlayout i Gridlayout
	
		Calculator_BorderLayout(){
	
	
			winCont = new JPanel();
			BorderLayout bl = new BorderLayout();
			winCont.setLayout(bl);
	
			//Pravi polje za prikaz i smješta ga u sjeverni dio prozora
	
			txtF = new JTextField(30);
			winCont.add("North",txtF);
			
			//Konstruiranje boutna
			
			button0 = new JButton("0");
			button1 = new JButton("1");
			button2 = new JButton("2");
			button3 = new JButton("3");
			button4 = new JButton("4");
			button5 = new JButton("5");
			button6 = new JButton("6");
			button7 = new JButton("7");
			button8 = new JButton("8");
			button9 = new JButton("9");
			bttPoint = new JButton(".");
			bttEq= new JButton("=");
			
			//Pravimo paletu botuna 12 kom
			
			p1 = new JPanel();
			GridLayout gl = new GridLayout(4, 3);
			p1.setLayout(gl);
			
			//dodajemo botune na paletu p1
			
			p1.add(button1);
			p1.add(button2);
			p1.add(button3);
			p1.add(button4);
			p1.add(button5);
			p1.add(button6);
			p1.add(button7);
			p1.add(button8);
			p1.add(button9);
			p1.add(bttPoint);
			p1.add(bttEq);
			
			//dodajemo paletu p1 u sredinu prozora
			
			winCont.add("Center",p1);
			
			
	
			//pravi okvir i postavlja njegovu paletu sa sadržajem
	
	
			JFrame frame = new JFrame("Kalkulator");
			frame.setContentPane(winCont);
			
			//Zadaje velièinu prozora tako da može prihvatiti sve kontrole
			
			
			frame.pack();
			
			//prikazuje prozor
			
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	public static void main(String[] args) {

			
		Calculator_BorderLayout calc= new Calculator_BorderLayout();
			
	}

}
