package Primjeri;

import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class ButtonClick extends JFrame {
	
	public void processButtonClick(ActionEvent actE) {
		
		System.out.println("Button was clicked");
		
	}

	public static void main(String[] args) {
		
		ButtonClick btc=new ButtonClick();
		
		JButton btt=new JButton("Click me!");
		
		
		
		btc.add(btt);
		
		btt.addActionListener(btc::processButtonClick);

		btc.pack();
		btc.setVisible(true);
		btc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}

}
