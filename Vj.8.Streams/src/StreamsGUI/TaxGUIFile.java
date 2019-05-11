package StreamsGUI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TaxGUIFile extends JFrame {
	
	
	JLabel lblGrIncome;
	JTextField txtGrossIncome= new JTextField(15);
	JLabel lblDependents= new JLabel("Number of Dependents:");
	JTextField txtDependents=new JTextField();
	JLabel lblState=new JLabel("Županija: ");
	
	
	//Definira model podataka za Combo box
	
	Vector<String> states=new Vector<>(50);
	
	//Prvi kombinirani popis za uzimanje podataka iz modela
	JComboBox chState= new JComboBox();
	
	JLabel lblTax=new JLabel("State tax: ");
	JTextField txtStateTax=new JTextField(10);
	JButton bGo=new JButton("GO");
	JButton bReset= new JButton("Reset");
	JButton ispis=new JButton("Ispis");
	JButton save=new JButton("Spremi");
	Arhiva arh= new Arhiva();
	Font fnt=new Font("SansSerif",Font.BOLD,15);
	
	TaxGUIFile(){
		
		lblGrIncome=new JLabel("Gross Income: ");
		GridLayout gl=new GridLayout(6, 2, 10, 10);
		setLayout(gl);
		
		setSize(500,250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(lblGrIncome);
		add(txtGrossIncome);
		add(lblDependents);
		add(txtDependents);
		add(lblState);
		add(chState);
		add(lblTax);
		add(txtStateTax);
		add(bGo);
		add(bReset);
		add(ispis);
		add(save);
		lblGrIncome.setFont(fnt);
		txtGrossIncome.setFont(fnt);
		lblDependents.setFont(fnt);
		txtDependents.setFont(fnt);
		lblState.setFont(fnt);
		chState.setFont(fnt);
		lblTax.setFont(fnt);
		txtStateTax.setFont(fnt);
		bGo.setFont(fnt);
		bReset.setFont(fnt);
		ispis.setFont(fnt);
		save.setFont(fnt);
		
		//popunjava stanja iz datotoeke
		
		populateStates();
		
		for(String s:states) {
			chState.addItem(s);
		}
		//chState.setSelectedIndex(0);
		txtStateTax.setEditable(false);
		
		//Obrada botuna "GO" korištenjem Lambda izraza
		
		bGo.addActionListener(ev->{
			try {
				int grossInc=Integer.parseInt(txtGrossIncome.getText());
				int dependents=Integer.parseInt(txtDependents.getText());
				String state = (String) chState.getSelectedItem();
				
				Tax tax=new Tax(grossInc, state, dependents);
				String sTax=Double.toString(tax.calcTax());
				txtStateTax.setText(sTax+"$");
				arh.puni(tax.getCustCounter(),tax);
				
				
				
				
				
			}catch(Exception e) {
				txtStateTax.setText(e.getMessage());
			}
		});
		
		//Obrada botuna "Reset" korištenjem lambda izraza
		
		bReset.addActionListener(ev->{
			txtGrossIncome.setText("");
			txtDependents.setText("");
			chState.setSelectedIndex(0);
			txtStateTax.setText("");
			
		});
		ispis.addActionListener(ev->{
			
			arh.ispis();
		});
		//Definira, instancira i registrira WindowAdapter
		//za obradu windowClosin Eventovog prozora
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		save.addActionListener(ev->{
			
			arh.spremi();
		});
		
	}
	
	private void populateStates() {
		
		states.add("Odaberi županiju");
		
		try(FileInputStream myFile=new FileInputStream("zupanije.txt");
				InputStreamReader inStreamReader=new InputStreamReader(myFile);
					BufferedReader reader=new BufferedReader(inStreamReader)){
			
			String stateName;
			
			while((stateName=reader.readLine())!=null) {
				states.add(stateName);
			}
			
			
			
		}catch(IOException e) {
			txtStateTax.setText("Can't read zupanije.txt: "+e.getMessage());
		}
		
	}

}
