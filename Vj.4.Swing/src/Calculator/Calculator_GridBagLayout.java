package Calculator;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Calculator_GridBagLayout {
	
	private JTextArea txtA;
	private JPanel p1;
	private JTextField displayField;
	private JButton button0;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton bttPoint;
	private JButton bttEq;
	private JButton bttSum;
	private JButton bttMin;
	private JButton bttMn;
	private JButton bttDj;
	private JButton bttCl;
	
	
	Calculator_GridBagLayout(){
		
		JFrame fr = new JFrame("Kalkulator");
		txtA = new JTextArea();
		displayField = new JTextField();
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
		bttSum = new JButton("+");
		bttMin = new JButton("-");
		bttMn = new JButton("*");
		bttDj = new JButton("/");
		bttCl = new JButton("C");
		
		
		
		fr.setVisible(true);
		
		p1 = new JPanel();
		
		GridBagLayout gb= new GridBagLayout();
		
		p1.setLayout(gb);
		
		GridBagConstraints constr= new GridBagConstraints();
		
		p1.add(button0);
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
		p1.add(bttSum);
		p1.add(bttMin);
		p1.add(bttMn);
		p1.add(bttDj);
		p1.add(bttCl);
		
		
		constr.gridx=0;
		
		constr.gridy=0;
		
		constr.gridheight=4;
		constr.gridwidth=5;
		
		
		constr.fill=constr.BOTH;
		
		
		constr.weightx=1.0;
		constr.weighty=1.0;
		constr.anchor=constr.CENTER;
		
		
		
		gb.setConstraints(txtA, constr);
		
		p1.add(txtA);
		
		
		constr.gridx=0;
		
		constr.gridy=4;
		
		constr.gridheight=1;
		constr.gridwidth=5;
		
		
		constr.fill=constr.BOTH;
		
		
		constr.weightx=1.0;
		constr.weighty=1.0;
		constr.anchor=constr.CENTER;
		
		
		
		gb.setConstraints(displayField, constr);
		
		p1.add(displayField);
		
		
		
		constr.gridx=0;
		
		constr.gridy=5;
		
		constr.gridheight=1;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(button1, constr);
		
		
		constr.gridx=1;
		
		constr.gridy=5;
		
		constr.gridheight=1;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(button2, constr);
		
		constr.gridx=2;
		
		constr.gridy=5;
		
		constr.gridheight=1;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(button3, constr);
		
		constr.gridx=0;
		
		constr.gridy=6;
		
		constr.gridheight=1;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(button4, constr);
		
		constr.gridx=1;
		
		constr.gridy=6;
		
		constr.gridheight=1;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(button5, constr);
		
		constr.gridx=2;
		
		constr.gridy=6;
		
		constr.gridheight=1;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(button6, constr);
		
		constr.gridx=0;
		
		constr.gridy=7;
		
		constr.gridheight=1;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(button7, constr);
		
		constr.gridx=1;
		
		constr.gridy=7;
		
		constr.gridheight=1;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(button8, constr);
		
		constr.gridx=2;
		
		constr.gridy=7;
		
		constr.gridheight=1;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(button9, constr);
		
		constr.gridx=0;
		
		constr.gridy=8;
		
		constr.gridheight=1;
		constr.gridwidth=2;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(button0, constr);
		
		constr.gridx=2;
		
		constr.gridy=8;
		
		constr.gridheight=1;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(bttPoint, constr);
		
		
		constr.gridx=3;
		
		constr.gridy=5;
		
		constr.gridheight=1;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(bttSum, constr);

		
		constr.gridx=3;
		
		constr.gridy=6;
		
		constr.gridheight=1;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(bttMin, constr);

		
		constr.gridx=3;
		
		constr.gridy=7;
		
		constr.gridheight=1;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(bttMn, constr);
		

		
		constr.gridx=3;
		
		constr.gridy=8;
		
		constr.gridheight=1;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(bttDj, constr);
		
		
		
		constr.gridx=4;
		
		constr.gridy=6;
		
		constr.gridheight=3;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(bttEq, constr);
		
		constr.gridx=4;
		
		constr.gridy=5;
		
		constr.gridheight=1;
		constr.gridwidth=1;
		
		constr.anchor=constr.CENTER;
		gb.setConstraints(bttCl, constr);
		
		
		
		CalculatorEngine cEng=new CalculatorEngine(this);
		
		
		
		button0.addActionListener(cEng);
		button1.addActionListener(cEng);
		button2.addActionListener(cEng);
		button3.addActionListener(cEng);
		button4.addActionListener(cEng);
		button5.addActionListener(cEng);
		button6.addActionListener(cEng);
		button7.addActionListener(cEng);
		button8.addActionListener(cEng);
		button9.addActionListener(cEng);
		bttEq.addActionListener(cEng);
		bttCl.addActionListener(cEng);
		bttPoint.addActionListener(cEng);
		bttSum.addActionListener(cEng);
		bttMin.addActionListener(cEng);
		bttMn.addActionListener(cEng);
		bttDj.addActionListener(cEng);
		fr.addWindowListener(cEng);
		
		
		
		
		fr.add(p1);
		fr.setSize(500,500);
		
		fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
	
		
		
		
	}
	
	

	public  String getTxtA() {
		return txtA.getText();
	}



	public void setTxtA(String str) {
		this.txtA.setText(str);;
	}



	public String getDisplayField() {
		return displayField.getText();
	}


	public void setDisplayField(String str) {
		this.displayField.setText(str);
	}




	public static void main(String[] args) {
		

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Calculator_GridBagLayout();
				
			}
		});
		
		
		
		

	}

}
