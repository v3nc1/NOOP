import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FormPanel extends JPanel {

	private FormListener fListener;
	private FormEvent fe;
	private JTextField txtField;
	private JComboBox combo;
	private JRadioButton rbtnMnth;
	private JRadioButton rbtnQuart;
	private JButton btnOK;
	private JButton btnList;
	private DefaultComboBoxModel comboModel;
	private JTextField txtGodina;
	private ButtonGroup rBttGr;

	public FormPanel() {

		setLayout(new GridBagLayout());
		createComp();

	}

	private void createComp() {
		
		
		txtField = new JTextField(10);
		rbtnMnth = new JRadioButton("Mjeseèno plaèanje");
		rbtnQuart = new JRadioButton("Kvartalno plaèanje");

		btnOK = new JButton("Izraèunaj");
		btnList = new JButton("Prikaz");
		comboModel = new DefaultComboBoxModel<>();
		comboModel.addElement("5%");
		comboModel.addElement("6%");
		comboModel.addElement("7%");
		comboModel.addElement("8%");
		comboModel.addElement("9%");
		comboModel.addElement("10%");
		comboModel.addElement("11%");
		combo = new JComboBox<>(comboModel);
		txtGodina = new JTextField(10);

		rBttGr = new ButtonGroup();

		rBttGr.add(rbtnMnth);
		rBttGr.add(rbtnQuart);
		rbtnMnth.setSelected(true);

		layoutComponents();

	}

	public void layoutComponents() {

		GridBagConstraints gbc = new GridBagConstraints();

		///////////////// First Row ////////////////////////
		gbc.weightx = 0.5;
		gbc.weighty = 1;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(new JLabel("Visina kredita"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 5, 0, 5);
		gbc.anchor = GridBagConstraints.LINE_START;
		add(txtField, gbc);
		///////////////// Second Row ////////////////////////
		gbc.weightx = 0.5;
		gbc.weighty = 1;

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(new JLabel("GodinaOtplate"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 5, 0, 5);
		gbc.anchor = GridBagConstraints.LINE_START;
		add(txtGodina, gbc);

		///////////////// Second Row ////////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.2;

		gbc.gridx = 1;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(new JLabel("Kamatna stopa"), gbc);

		gbc.gridx = 1;
		gbc.gridy++;
		gbc.insets = new Insets(0, 5, 0, 5);
		gbc.anchor = GridBagConstraints.LINE_START;
		add(combo, gbc);

		///////////////// Third Row ////////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.1;

		gbc.gridx = 1;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(rbtnMnth, gbc);

		gbc.gridx = 1;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(rbtnQuart, gbc);
		///////////////// Last Row ////////////////////////
		gbc.weightx = 1;
		gbc.weighty = 2;

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(0, 10, 0, 0);
		gbc.anchor = GridBagConstraints.LINE_END;
		add(btnList, gbc);

		gbc.gridx = 1;

		gbc.insets = new Insets(0, 5, 0, 12);
		gbc.anchor = GridBagConstraints.LINE_END;
		add(btnOK, gbc);
		/*
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
				fListener.calculateFormEventOccured(fe);
				/*
				 * Calculation calc=new Calculation(fe.getKreda(), fe.getKamata(),
				 * fe.getNacin(), fe.getGodina());
				 * 
				 * calcList.add(calc); fe.setCals(calcList);
				 */
/*
			}
		});

		btnList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				fListener.listFormEventOccured();
				

			}
		});
		*/

	}

	public void activateForm() {

	}

	private float getKamata() {

		float kam;
		if (combo.getSelectedItem().equals("5%")) {

			kam = (float) 0.05;
		} else if (combo.getSelectedItem().equals("6%")) {

			kam = (float) 0.06;
		} else if (combo.getSelectedItem().equals("7%")) {

			kam = (float) 0.07;
		} else if (combo.getSelectedItem().equals("8%")) {

			kam = (float) 0.08;
		} else if (combo.getSelectedItem().equals("9%")) {

			kam = (float) 0.09;
		} else if (combo.getSelectedItem().equals("10%")) {

			kam = (float) 0.1;
		} else {

			kam = (float) 0.11;
		}

		return kam;
	}

	public void setFormListener(FormListener fl) {

		fListener = fl;

	}

	public void setFormEvent(FormEvent fe) {

		this.fe = fe;

	}

	public JTextField getTxtField() {
		return txtField;
	}

	public JComboBox getCombo() {
		return combo;
	}

	public JRadioButton getRbtnMnth() {
		return rbtnMnth;
	}

	public JRadioButton getRbtnQuart() {
		return rbtnQuart;
	}

	public JButton getBtnOK() {
		return btnOK;
	}

	public JButton getBtnList() {
		return btnList;
	}

	public DefaultComboBoxModel getComboModel() {
		return comboModel;
	}

	public JTextField getTxtGodina() {
		return txtGodina;
	}

	public ButtonGroup getrBttGr() {
		return rBttGr;
	}

	public FormListener getfListener() {
		return fListener;
	}

	public FormEvent getFe() {
		return fe;
	}
	
	public float getKam() {
		
		return getKamata();
	}
	

}
