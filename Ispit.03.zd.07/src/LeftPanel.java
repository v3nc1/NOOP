import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LeftPanel extends JPanel {
	
	private JTextField txtName;
	private JTextField txtLast;
	private JTextField txtId;
	private JComboBox cmbDep;
	private DefaultComboBoxModel cmbBoxMod;
	private JRadioButton rbtVss;
	private JRadioButton rbtSss;
	private ButtonGroup btnGroup;
	private JCheckBox chkDnp;
	private JCheckBox chkPrek;
	private JCheckBox chkDodDj;
	
	
	public LeftPanel() {
		
		createComps();
		layoutRun();
		}
	
	
	private void createComps() {
		
		txtName=new JTextField(10);
		txtLast=new JTextField(10);
		txtId=new JTextField(5);
		cmbDep=new JComboBox<>();
		cmbBoxMod=new DefaultComboBoxModel<>();
		rbtVss=new JRadioButton("Visoka struèna sprema");
		rbtSss=new JRadioButton("Srednja struèna sprema");
		btnGroup=new ButtonGroup();
		chkDnp=new JCheckBox("Dodatak na plaæu");
		chkPrek=new JCheckBox("Prekovremeni");
		chkDodDj=new JCheckBox("Dodatak za djecu");
		
		cmbBoxMod.addElement("HR");
		cmbBoxMod.addElement("Servis");
		cmbBoxMod.addElement("Financije");
		cmbBoxMod.addElement("Šljaker");
		cmbDep.setModel(cmbBoxMod);
		
		btnGroup.add(rbtVss);
		btnGroup.add(rbtSss);
		
		
		
	}
	
	public String getTxtName() {
		return txtName.getText();
	}


	public String getTxtLast() {
		return txtLast.getText();
	}


	public String getTxtId() {
		return txtId.getText();
	}


	public String getCmbDep() {
		return cmbDep.getSelectedItem().toString();
	}




	public String getSs() {
		
		if(rbtSss.isSelected()) {
			
			
			return rbtSss.getText();
		}else {
			return rbtVss.getText();
		}
	}


	public String getChk() {
		
		String chkValue="";
		
		if(chkDnp.isSelected()) {
			
			chkValue+=chkDnp.getText()+"\n";
			
		}
		if(chkPrek.isSelected()) {
			
			chkValue+=chkPrek.getText()+"\n";
		}
		if(chkDodDj.isSelected()) {
			
			chkValue+=chkDodDj.getText()+"\n";
		}
		
		return chkValue;
	}
	
	public void resetData() {
		
		txtId.setText("");
		txtName.setText("");
		txtLast.setText("");
		cmbDep.setSelectedIndex(0);
		rbtSss.setSelected(false);
		rbtVss.setSelected(false);
		chkDnp.setSelected(false);
		chkDodDj.setSelected(false);
		chkPrek.setSelected(false);
		
		
	}




	private void layoutRun() {
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc=new GridBagConstraints();
		
		//// 1 Red ////
		gc.gridx=0;
		gc.gridy=0;
		
		gc.insets=new Insets(5, 10, 10, 10);
		gc.anchor=gc.LINE_START;
		
		add(new Label("Ime"),gc);
		
		gc.gridy=1;
		
		add(txtName,gc);
		
		gc.gridx=1;
		gc.gridy=0;
		
		add(new Label("Prezime"),gc);
		
		gc.gridx=1;
		gc.gridy=1;
		
		add(txtLast,gc);
		
		gc.gridx=2;
		gc.gridy=0;
		
		add(new Label("ID"),gc);
		
		gc.gridx=2;
		gc.gridy=1;
		
		add(txtId,gc);
		
		
		//// 2 Red ////
		
		
		gc.gridx=0;
		gc.gridy=2;
		
		add(new Label("Odjel"),gc);
		
		gc.gridx=0;
		gc.gridy=3;
		
		add(cmbDep,gc);
		
		
		gc.gridx=0;
		gc.gridy=4;
		
		add(rbtVss,gc);
		
		gc.gridx=0;
		gc.gridy=5;
		
		add(rbtSss,gc);
		
		gc.gridx=1;
		gc.gridy=4;
		
		gc.insets=new Insets(10, 30, 10, 10);
		
		add(chkDnp,gc);
		
		gc.gridx=1;
		gc.gridy=5;
		
		add(chkPrek,gc);
		
		gc.gridx=1;
		gc.gridy=6;
		
		add(chkDodDj,gc);
		
		
		
		
		
		
		
	}
	
	

}
