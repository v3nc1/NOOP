import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class FormAction extends java.awt.event.WindowAdapter implements ActionListener {
	
	GameFrame gFrame;
	//private JTextArea;
	
	public FormAction() {

		
	}
	public FormAction(GameFrame gx) {
		
		gFrame=gx;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	
	public void windowOpened(WindowEvent e) {

		
	}

	/*public void windowClosing(WindowEvent e) {

		JOptionPane.showMessageDialog(null, "Good by", "Player info", JOptionPane.QUESTION_MESSAGE);



	}*/
	public void setT(String txt) {
		
		gFrame.setTxt(txt);
	}

}
