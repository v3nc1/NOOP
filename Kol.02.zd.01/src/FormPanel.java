import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormPanel extends JPanel implements FormListener {
	
	private JLabel vessLbl;
	private JTextField vessField;
	private JLabel nameLbl;
	private JTextField nameField;
	private JLabel ageCategory;
	private JList ageList;
	private DefaultListModel ageModel;
	private JButton confirmBtn;
	private JPanel panel;
	public JTextArea txtArea;

	
	
	public FormPanel() {
		
		setLayout(new BorderLayout());		
		createComp();
		panel.setLayout(new FlowLayout());
		panel.add(vessLbl);
		panel.add(vessField);
		panel.add(nameLbl);
		panel.add(nameField);
		panel.add(ageCategory);
		panel.add(ageList);
		add(panel,BorderLayout.NORTH);
		add(confirmBtn,BorderLayout.CENTER);
		activateComp();
		
	}
	
	private void createComp() {
		
	
		vessLbl=new JLabel("VesselType");
		vessField=new JTextField(10);
		nameLbl=new JLabel("VesselName: ");
		nameField=new JTextField(10);
		ageCategory=new JLabel("VesselAgeCat: ");
		ageList=new JList<>(ageModelList());
		confirmBtn=new JButton("Confirm");
		panel=new JPanel();
		
	}
	
	private DefaultListModel ageModelList() {
		
		ageModel=new DefaultListModel<>();
		
		ageModel.add(0, "0 to 10 years");
		ageModel.add(1, "11 to 30 years");
		ageModel.add(2, "31 to 50 years");
		
		return ageModel;
		
		
	}
	
	private void activateComp() {
		
		confirmBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			

				Vessel vessel=new Vessel(vessField.getText(), nameField.getText(), ageList.getSelectedIndex());
				FormEvent formEvent=new FormEvent(vessel);

				
				formEventOccured(formEvent);
				resetForm();
			}
		});
		
	}
	
	public void setFormListener(FormListener fl) {
			
	}
	
	public void resetForm() {
		
		vessField.setText("");
		nameField.setText("");
		
	}

	@Override
	public void formEventOccured(FormEvent ev) {
		
		txtArea.append("//////////Vessel/////////////\n");
		txtArea.append("Name: "+ev.getName()+" -> type: "+ev.getType()+" -> age category: "+ev.getAgeCat()+"\n");
		
	}
	
	
	

}
