import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DataPanel extends JPanel implements FormListener{
	
	private JTextField payment;
	private JTextArea txtAr;
	
	
	
	
	
	public DataPanel() {
		
		setLayout(new BorderLayout());
		
		createComp();
		add(new JScrollPane(txtAr,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.NORTH);
		add(payment,BorderLayout.SOUTH);
		
	}
	
	public void createComp() {
		
		payment=new JTextField(20);
		txtAr=new JTextArea(20,20);
		
				
	}
	
	public void setData(float dta) {
		
	}
	
	public void showCalculations(ArrayList<Calculation> arrDta) {
		
		for(Calculation cal:arrDta) {
			
			txtAr.append("/////Calculation/////\n");
			txtAr.append("Kredit: "+cal.getKreda()+"\n");
			txtAr.append("Kamata: "+cal.getKamata()+"\n");
			txtAr.append("Godina otplate: "+cal.getGodina()+"\n");
			txtAr.append("Rata: "+new DecimalFormat("0.00").format(cal.getPay())+"\n");
			
		}
		
	}

	@Override
	public void calculateFormEventOccured(FormEvent fe) {
		// TODO Auto-generated method stub
		/*
		new Calculation(fe.getKreda(), fe.getKamata(), fe.getNacin(), fe.getGodina());
		
		payment.setText(new DecimalFormat("0.00").format(Calculation.calculate(fe.getKreda(), fe.getKamata(), fe.getNacin(), fe.getGodina())));
		/*
		txtAr.append("/////Calculation/////\n");
		txtAr.append("Kredit: "+fe.getKreda()+"\n");
		txtAr.append("Kamata: "+fe.getKamata()+"\n");
		txtAr.append("Godina otplate: "+fe.getGodina()+"\n");
		txtAr.append("Rata: "+new DecimalFormat("0.00").format(Calculation.calculate(fe.getKreda(), fe.getKamata(), fe.getNacin(), fe.getGodina()))+"\n");
		*/
	}

	public JTextField getPayment() {
		return payment;
	}

	public JTextArea getTxtAr() {
		return txtAr;
	}
	
	

	public void setTxtAr(String st) {
		payment.setText(st);;
	}

	@Override
	public void listFormEventOccured(FormEvent fe) {
		showCalculations(fe.getCals());
		
		
		
	}

}
