import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SearchPanel extends JDialog implements dataSearch {
	
	
	private JPanel topPanel;
	private JPanel midPanel;
	private JPanel bottPanel;
	private JLabel nameLbl;
	private JLabel lastLbl;
	private JLabel depLbl;
	private JLabel idLbl;
	private JLabel ctzLbl;
	private JTextField txtName;
	private JTextField txtLast;
	private JTextField txtDep;
	private JTextField txtCit;
	private JTextField txtId;
	private JButton bttnExit;
	private JButton bttnSearch;
	private Map<Integer,Student> stList;
	
	
	public SearchPanel(JFrame fr) {
		
		super(fr,"Student's info",false);
		
		createComps();
		activateApp();

	}
	
	

	public void activateApp() {
		
		bttnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int idSearch=Integer.parseInt(txtId.getText());
				
				
				for (Integer s:stList.keySet()) {
					
					if(s==idSearch) {
						
						txtName.setText(stList.get(s).getFirstN());
						txtLast.setText(stList.get(s).getLastN());
						txtDep.setText(stList.get(s).getDepartment());
						txtCit.setText(stList.get(s).getCitizen());
								
						
					}
				}
				
				
				
			}
		});
		
		
	}
	
	@Override
	public void getData(DataEvent de) {
		// TODO Auto-generated method stub
		
	}
	
	private void setBords() {
		
		Border top=BorderFactory.createTitledBorder("Student's info");
		Border bottom=BorderFactory.createEmptyBorder(10, 10, 10, 10);
		
		bottPanel.setBorder(BorderFactory.createCompoundBorder(top, bottom));
		
	}
	
	public void setList(Map<Integer,Student> sl) {
		
		stList=sl;
		
		
	}

	public void createComps() {
		
		
		
		setVisible(true);
		setSize(500, 300);
		setResizable(false);
		
		setLayout(new BorderLayout());
		
		
		topPanel=new JPanel();
		midPanel=new JPanel();
		bottPanel=new JPanel();
		nameLbl=new JLabel("Fist name:");
		lastLbl=new JLabel("Last name:");
		depLbl=new JLabel("Department:");
		idLbl=new JLabel("Enter Unique ID:");
		ctzLbl=new JLabel("Citizenship");
		txtName=new JTextField(10);
		txtLast=new JTextField(10);
		txtDep=new JTextField(20);
		txtCit=new JTextField(20);
		txtId=new JTextField(7);
		bttnSearch=new JButton("Search");
		bttnExit=new JButton("Exit");
		
		GridBagConstraints gc=new GridBagConstraints();
		
		topPanel.setLayout(new GridBagLayout());
		
		// Row 1 //
		
		gc.gridx=0;
		gc.gridy=0;
		gc.insets=new Insets(5, 5, 5, 5);
		gc.anchor=GridBagConstraints.LINE_END;
		
		topPanel.add(idLbl,gc);
		
		gc.gridx=1;
		gc.gridy=0;
		
		gc.anchor=GridBagConstraints.CENTER;
		
		topPanel.add(txtId,gc);
		
		add(topPanel,BorderLayout.NORTH);
		
		
		// Row 2 //
		midPanel.setLayout(new GridBagLayout());
		
		
		gc.gridx=0;
		gc.gridy=0;
		gc.fill=gc.FIRST_LINE_START;
		gc.insets=new Insets(5, 5, 5, 5);
		gc.anchor=GridBagConstraints.WEST;
		
		midPanel.add(bttnSearch,gc);
		
		gc.gridx=1;
		gc.gridy=0;
		gc.fill=gc.FIRST_LINE_START;
		gc.anchor=GridBagConstraints.EAST;
		
		midPanel.add(bttnExit,gc);
	
		add(midPanel,BorderLayout.CENTER);
		
		// Row 3 //
		setBords();
		bottPanel.setLayout(new GridLayout(2, 4));
		
		bottPanel.add(nameLbl);
		bottPanel.add(txtName);
		bottPanel.add(depLbl);
		bottPanel.add(txtDep);
		bottPanel.add(lastLbl);
		bottPanel.add(txtLast);
		bottPanel.add(ctzLbl);
		bottPanel.add(txtCit);
		
		add(bottPanel,BorderLayout.SOUTH);

	}


}
