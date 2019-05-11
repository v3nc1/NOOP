import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	private FormPanel fp;
	private DataPanel dp;
	private Calculation calc;
	private ArrayList<Calculation> calList;
	
	public MainFrame() {
		
		createComp();
		activateApp();
		
		
		
	}
	
	private void createComp() {
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		fp=new FormPanel();
		dp=new DataPanel();
		fp.setFormListener(dp);
		add(fp,BorderLayout.WEST);
		add(dp,BorderLayout.EAST);
		calList=new ArrayList<>();
		//calc=new Calculation(fp.txt.getKreda(), fp.getKm(), fp.getNacin(), fp.getGodina());
		
		
	}
	
	public void activateApp() {
		
		fp.getBtnOK().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				if (fp.getFe() == null) {
					fp.setFormEvent(new FormEvent(this));
				}

				fp.getFe().setKreda(Float.parseFloat(fp.getTxtField().getText()));
				fp.getFe().setGodina(Integer.parseInt(fp.getTxtGodina().getText()));
				fp.getFe().setKamata(fp.getKam());
				
				
				if (fp.getRbtnMnth().isSelected()) {
					

					fp.getFe().setNacin(12);
					
				} else {
					fp.getFe().setNacin(4);
				}
				
				calc=new Calculation(fp.getFe().getKreda(), fp.getFe().getKamata(), fp.getFe().getNacin(), fp.getFe().getGodina());
				
				calList.add(calc);
				
				fp.getFe().setCals(calList);
				
				dp.setTxtAr(new DecimalFormat("0.00").format(Calculation.calculate(fp.getFe().getKreda(), fp.getFe().getKamata(),  fp.getFe().getNacin(), fp.getFe().getGodina())));
				
				//dp.calculateFormEventOccured(fp.getFe());
			}
		});
		
		fp.getBtnList().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				dp.showCalculations(fp.getFe().getCals());
				
			}
		});
		
		
	}

}
