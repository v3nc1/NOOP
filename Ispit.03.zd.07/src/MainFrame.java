import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class MainFrame extends JFrame{
	
	
	private LeftPanel lp;
	private RightPanel rp;
	private SearchPanel searchPanel;
	private ArrayList<Djelatnik> baza;
	private Djelatnik broj;
	private Set<Integer> chkId;
	private Data data;
	
	
	public MainFrame() {
		
		createComps();
		lp=new LeftPanel();
		rp=new RightPanel();
		baza=new ArrayList<>();
		chkId=new HashSet<>();
		
				         
		bordersSet();
		layoutRun();
		action();
		
		
	}
	
	private void action() {
		
		rp.getBtnSend().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(chkId.contains(Integer.parseInt(lp.getTxtId()))){
						
					JOptionPane.showMessageDialog(null, "ID postoji u bazi!", "Neispravni podaci", JOptionPane.ERROR_MESSAGE);
					
				}else{
					chkId.add(Integer.parseInt(lp.getTxtId()));
					broj=new Djelatnik(Integer.parseInt(lp.getTxtId()), lp.getTxtName(), 
							lp.getTxtLast(), lp.getCmbDep(), lp.getSs(), lp.getChk());
					
					baza.add(broj);
					
					
					rp.getTxtArea().append("ID: "+ broj.getId()+"\n");
					rp.getTxtArea().append("Ime: "+ broj.getIme()+"\n");
					rp.getTxtArea().append("Prezime: "+ broj.getPrezime()+"\n");
					rp.getTxtArea().append("Odjel: "+ broj.getOdjel()+"\n");
					rp.getTxtArea().append("Struèna sprema: "+ broj.getSs()+"\n");
					rp.getTxtArea().append("Dodatci: \n"+ broj.getDodaci()+"\n");
					
					rp.getBtnSearch().setEnabled(true);
				}
				
				
				
			}
		});
		
		
		
		rp.getBtnSearch().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				searchPanel=new SearchPanel(new JFrame());
				
				SearchDataEvent se=new SearchDataEvent(this);
				
				se.setBazaDj(baza);
				
				
				searchPanel.getBaza(se);
							
			}
		});
		
		rp.getBtnCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				rp.resetData();
				lp.resetData();
				
			}
		});
		
		
	}

	public void setListener(Data d) {
		
		data=d;
		
	}

	
	
	private void createComps() {
		
		setVisible(true);
		setSize(800, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		
		
		
	}
	
	
	
	
	private void bordersSet() {
		
		Border top=BorderFactory.createTitledBorder("Podaci");
		Border bott=BorderFactory.createEmptyBorder(10, 10, 10, 10);
		
		
		lp.setBorder(BorderFactory.createCompoundBorder(top, bott));
		
		
	}
	
	private void layoutRun() {
		
		setLayout(new FlowLayout());
		
		
		add(lp);
		add(rp);
		
		
		
	}

}
