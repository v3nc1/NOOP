package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class DataForm extends JPanel {
	
	
	private JTextField nameField;
	private JTextField mailField;
	private JRadioButton emplRadio;
	private JRadioButton unemplRadio;
	private ButtonGroup groupRadio;
	private JComboBox comboEducation;
	private JList listRegion;
	private JButton btnSubmit;
	private FormDataListener fdl;
	
	
	
	
	
	public DataForm() {
		
		setLayout(new GridBagLayout());
		runCreate();
		runLayout();
		runAction();
		
	}
	
	private void runAction() {
		
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name=nameField.getText();
				String mail=mailField.getText();
				String employment=groupRadio.getSelection().getActionCommand();
				String education=(String) comboEducation.getSelectedItem();
				String region=(String) listRegion.getSelectedValue();
				
				FormDataObject fDataObject=new FormDataObject(this, name, mail, employment, education, region);
				
				if(fdl != null) {
					
					fdl.dataFormEventOccured(fDataObject);
				}
				
			
				
			}
		});
	}
	
	public void setFormDataListener(FormDataListener listener) {
		
		this.fdl=listener;
	}
	
	private void runCreate() {
		
		
		nameField=new JTextField(10);
		mailField=new JTextField(10);
		btnSubmit=new JButton("Submit");
		
		//Radio buttons
		emplRadio=new JRadioButton("Employed");
		unemplRadio=new JRadioButton("Unemployed");
		groupRadio=new ButtonGroup();
		groupRadio.add(emplRadio);
		groupRadio.add(unemplRadio);
		emplRadio.setActionCommand("Employed");
		unemplRadio.setActionCommand("Unemployed");
		emplRadio.setSelected(true);
		
		//ComboBox
		comboEducation=new JComboBox<>();
		DefaultComboBoxModel<String> eduComboModel=new DefaultComboBoxModel<>();
		eduComboModel.addElement("Higher education");
		eduComboModel.addElement("Elementary school");
		eduComboModel.addElement("Bachelor's degree");
		eduComboModel.addElement("Master's degree");
		eduComboModel.addElement("PhD");
		comboEducation.setModel(eduComboModel);
		comboEducation.setSelectedIndex(0);
		
		//JList
		
		DefaultListModel<String> regListModel=new DefaultListModel<>();
		regListModel.addElement("North region");
		regListModel.addElement("South region");
		regListModel.addElement("East region");
		regListModel.addElement("West region");
		
		listRegion=new JList<>(regListModel);
		listRegion.setSelectionMode(0);
		listRegion.setSize(200, 250);
		listRegion.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		//Borders
		Border outer=BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner=BorderFactory.createTitledBorder("User data");
		
		Border border=BorderFactory.createCompoundBorder(outer, inner);
		
		this.setBorder(border);
		
		//Size
		Dimension dims=getPreferredSize();
		dims.height=300;
		setPreferredSize(dims);
		
		
	
	}
	
	private void runLayout() {
		
		GridBagConstraints gc=new GridBagConstraints();
		
		
		/////// First / Second Column /////////
		
		gc.weightx=0;
		gc.weighty=0;
		
		gc.gridx=0;
		gc.gridy=0;
		
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(10, 5, 5, 5);
		add(new JLabel("Name"),gc);
		
		gc.gridx=1;
		
		add(nameField,gc);
		
		gc.gridx=0;
		gc.gridy=1;
		
		add(new JLabel("Mail"),gc);
		
		gc.gridx=1;
		
		add(mailField,gc);
		
		
		gc.gridx=0;
		gc.gridy=2;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(0, 5, 5, 5);
		add(new JLabel("Employment"),gc);
		
		
		gc.gridx=1;
		gc.gridy=3;
		gc.anchor=GridBagConstraints.LINE_START;
		add(emplRadio,gc);
		
		gc.gridy=4;
		
		add(unemplRadio,gc);
		
		
		/////// Third Column /////////

		gc.weightx=0;
		gc.weighty=0;
		
		gc.gridx=2;
		gc.gridy=0;
		
		add(Box.createHorizontalStrut(20),gc);
		
		
		/////// Fourth / Fifth Column /////////
		
		gc.gridx=3;
		gc.gridy=0;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(10, 5, 5, 5);
		add(new JLabel("Education"),gc);
		
		gc.gridy=1;
		gc.gridx=4;
		add(comboEducation,gc);
		
		
		/////// Fourth / Fifth Column /////////
		
		gc.gridx=5;
		gc.gridy=0;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(10, 5, 5, 5);
		add(new JLabel("Region"),gc);
		
		gc.gridy=1;
		gc.gridx=6;
		add(listRegion,gc);
		
		gc.gridx=5;
		gc.gridy=4;
		
		add(btnSubmit,gc);
		
		
		
		
	}

}
