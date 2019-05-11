package gui;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LeftPanel extends JPanel {

	private JLabel lblName;
	private JLabel lblCity;
	private JLabel lblMail;

	private JTextField nameField;
	private JTextField cityField;
	private JTextField mailField;

	private JButton btnSend;
	private FormListener lFormLst;
	private ArrayList<JTextField> txtArray = new ArrayList<>();
	private int counter = 1;

	public LeftPanel() {

		Dimension dim = getPreferredSize();
		dim.width = 220;
		setPreferredSize(dim);
		setBorders();
		createLeftComp();
		layoutLeft();
		activateForm();
	}

	private void layoutLeft() {

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblName, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gbc);
		///////////////////// Second Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblCity, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(cityField, gbc);

		///////////////////// Third Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblMail, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(mailField, gbc);

		///////////////////// Last Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 1;

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(btnSend, gbc);
	}

	private void createLeftComp() {

		lblName = new JLabel("Name: ");
		lblCity = new JLabel("City: ");
		lblMail = new JLabel("Mail: ");
		nameField = new JTextField(10);
		cityField = new JTextField(10);
		mailField = new JTextField(10);
		btnSend = new JButton("Send data");
		
		txtArray.add(nameField);
		txtArray.add(cityField);
		txtArray.add(mailField);

	}

	private void setBorders() {

		Border inner = BorderFactory.createTitledBorder("Customer data:");
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		setBorder(BorderFactory.createCompoundBorder(outer, inner));
	}

	private void activateForm() {

		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				

				String name = nameField.getText();
				String city = cityField.getText();
				String mail = mailField.getText();

				LeftFormEvent lfe = new LeftFormEvent(this);
				lfe.setName(name);
				lfe.setCity(city);
				lfe.setMail(mail);
				lfe.setCounter(counter);

				if (lFormLst != null) {

					lFormLst.leftPanelEventOccured(lfe);

				}
				
				for(JTextField tf : txtArray) {
					
					tf.setText("");
				}
				

			}
		});
		
		
	}

	public void setLeftFormList(FormListener lst) {

		this.lFormLst = lst;
	}
	
	

	

}
