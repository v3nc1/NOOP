import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.AbstractDocument.LeafElement;

public class Mainframe extends JFrame {

	private JPanel leftP;
	private JPanel rightP;
	private JTextField txtA;
	private JTextField txtB;
	private JComboBox cmbOperator;
	private DefaultComboBoxModel cmbModel;
	private JButton btnCalc;

	private JTextField txtRez;
	private JTextArea rezDisplay;

	public Mainframe(){
		
		setVisible(true);
		setSize(500, 500);
		setAlwaysOnTop(true);
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		runCreate();
		runLayout();
		runAction();
		
		
	
	}
	
	private void runAction() {
		
		btnCalc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				

				SimpleCalculator sc = new SimpleCalculator();

				float a = Float.parseFloat(txtA.getText());
				float b = Float.parseFloat(txtB.getText());
				
				System.out.println(a+b);
				
				String operator = cmbOperator.getSelectedItem().toString();
				
				if (operator.equals("+")) {

					sc.setStrategy(new AddStrategy());
					txtRez.setText(sc.performCalculation(a, b)+" ");
					
					rezDisplay.append(""+sc.performCalculation(a, b)+"\n");

				} else if (operator.equals("-")) {

					sc.setStrategy(new SubsStrategy());
					txtRez.setText(sc.performCalculation(a, b)+" ");
					rezDisplay.append(""+sc.performCalculation(a, b)+"\n");

				} else if (operator.equals("*")) {

					sc.setStrategy(new MultiplyStrategy());
					txtRez.setText(sc.performCalculation(a, b)+" ");
					rezDisplay.append(""+sc.performCalculation(a, b)+"\n");
				} else if (operator.equals("/")) {

					sc.setStrategy(new DivisionStrategy());

					txtRez.setText(sc.performCalculation(a, b)+" ");
					rezDisplay.append(""+sc.performCalculation(a, b)+"\n");

				}
				
			}
		});
		
	}
	
	private void runCreate() {
		
		leftP=new JPanel();
		rightP=new JPanel();
		txtA=new JTextField(10);
		txtB=new JTextField(10);
		cmbOperator=new JComboBox<>();
		cmbModel=new DefaultComboBoxModel<>();
		
		cmbModel.addElement("+");
		cmbModel.addElement("-");
		cmbModel.addElement("*");
		cmbModel.addElement("/");
		
		cmbOperator.setModel(cmbModel);
		
		btnCalc=new JButton("Izracunaj");
		
		txtRez=new JTextField(10);
		
		rezDisplay=new JTextArea(10,10);
	
		
	}
	
	private void runLayout() {
		
		setLayout(new FlowLayout());
		
		leftP.setLayout(new GridBagLayout());
		rightP.setLayout(new GridBagLayout());
		
		GridBagConstraints gc=new GridBagConstraints();
		
		gc.gridx=0;
		gc.gridy=0;
		gc.weightx=1.0;
		gc.weighty=1.0;
		gc.anchor=gc.LINE_START;
		gc.insets=new Insets(10, 10, 10, 10);
		
		leftP.add(new JLabel("prvi broj:"),gc);
		
		gc.gridy=1;
		
		leftP.add(txtA, gc);
		
		gc.gridy=2;
		
		leftP.add(new JLabel("drugi broj"), gc);
		
		gc.gridy=3;
		
		leftP.add(txtB, gc);
		
		gc.gridy=4;
		
		leftP.add(new JLabel("Izaberi matematicku operaciju;"), gc);
		
		gc.gridy=5;
		
		leftP.add(cmbOperator, gc);
		
		gc.gridy=6;
		
		leftP.add(btnCalc, gc);
		
		runBorder(leftP);
		
		gc.gridy=0;
		
		rightP.add(new JLabel("Rezultat"),gc);
		
		gc.gridy=1;
		
		rightP.add(txtRez, gc);
		
		gc.gridy=2;
		
		rightP.add(new JLabel("Prikaz svih rezultata"), gc);
		
		gc.gridy=3;
		//gc.gridheight=5;
		
		rightP.add(new JScrollPane(rezDisplay, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), gc);
		
		
		
		add(leftP);
		add(rightP);
		
		
		
	}
	
	private void runBorder(JPanel panel) {
		
		
		Border top=BorderFactory.createTitledBorder("Unos");
		Border bott=BorderFactory.createEmptyBorder(10, 10, 10, 10);
		
		panel.setBorder(BorderFactory.createCompoundBorder(top, bott));
	}
}
