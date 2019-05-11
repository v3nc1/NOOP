package Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CalculatorEngine extends java.awt.event.WindowAdapter implements ActionListener {
	
	Calculator_GridBagLayout parent;
	double a;
	double b;
	double c;
	int br;
	String op;
	
	
	
	
	
	public CalculatorEngine(Calculator_GridBagLayout parent) {
		
		this.parent = parent;
	}


	public void actionPerformed(ActionEvent e) {
		
		JButton jBtt = (JButton) e.getSource();
		
		if (jBtt.getText() =="C") {
			a=0;
			
			parent.setDisplayField(null);
			parent.setTxtA("\n");
		
		}else if (jBtt.getText() =="+"){
			
			op="+";
			
			a+=Double.parseDouble(parent.getDisplayField());
			parent.setTxtA(parent.getTxtA()+parent.getDisplayField()+jBtt.getText());
			parent.setDisplayField(null);
			
			
		}else if (jBtt.getText() =="-"){
			
			op="-";
			
			if(a==0) {
				a=Double.parseDouble(parent.getDisplayField());
				parent.setTxtA(parent.getTxtA()+parent.getDisplayField()+jBtt.getText());
				parent.setDisplayField(null);
				}else {
					a-=Double.parseDouble(parent.getDisplayField());
					parent.setTxtA(parent.getTxtA()+parent.getDisplayField()+jBtt.getText());
					parent.setDisplayField(null);
				}
			br++;
		}else if (jBtt.getText() =="*"){
			op="*";
			br=0;
			if(a==0) {
				a=Double.parseDouble(parent.getDisplayField());
				parent.setTxtA(parent.getTxtA()+parent.getDisplayField()+jBtt.getText());
				parent.setDisplayField(null);
			}else {	
			a*=Double.parseDouble(parent.getDisplayField());
			parent.setTxtA(parent.getTxtA()+parent.getDisplayField()+jBtt.getText());
			parent.setDisplayField(null);
			}
		}else if (jBtt.getText() =="/"){
			op="/";
			
			if(a==0) {
			a=Double.parseDouble(parent.getDisplayField());
			parent.setTxtA(parent.getTxtA()+parent.getDisplayField()+jBtt.getText());
			parent.setDisplayField(null);
			}else {
				a/=Double.parseDouble(parent.getDisplayField());
				parent.setTxtA(parent.getTxtA()+parent.getDisplayField()+jBtt.getText());
				parent.setDisplayField(null);
			}
			
		}else if (jBtt.getText() =="="){
			
			
			switch(op) {
				
			case "+":
				
				a+=Double.parseDouble(parent.getDisplayField());
				break;
			case "-":			
				a-=Double.parseDouble(parent.getDisplayField());
				break;
			case "*":
				a*=Double.parseDouble(parent.getDisplayField());
				break;
			case "/":
				a/=Double.parseDouble(parent.getDisplayField());
				break;
				
			}
			
			parent.setTxtA(parent.getTxtA()+parent.getDisplayField());
			parent.setDisplayField(String.valueOf(a));
			parent.setTxtA(parent.getTxtA()+"="+parent.getDisplayField()+" ");
		}
		
		else {
			
			String display = parent.getDisplayField();
			
			parent.setDisplayField(display + jBtt.getText());
			
			
		}
	

	}
	public void windowClosing(WindowEvent e) {
		
		JOptionPane.showMessageDialog(null, "Hvala na korištenju", "EXIT",JOptionPane.WARNING_MESSAGE);
	}
	
	public void windowOpened (WindowEvent e) {
		
		//JOptionPane.showMessageDialog(null, "Hvala na korištenju", "ULAZ",JOptionPane.WARNING_MESSAGE);
	}

}
