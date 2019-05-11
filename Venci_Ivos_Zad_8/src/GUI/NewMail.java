package GUI;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NewMail extends JDialog {

	private JPanel panel;
	private JTextField txtFrom;
	private JComboBox cmbTo;
	private DefaultComboBoxModel cmbModel;
	private JTextArea txtMail;
	private JScrollPane scroll;
	private JButton btnSend;
	private MailEventAction mailEA;

	public NewMail(JFrame frame) {

		super(frame, "New mail", false);

		setVisible(true);
		setSize(600, 400);
		setResizable(false);
		createComps();
		layoutRun();
		actionRun();

	}

	public void setMail(String mail, DefaultComboBoxModel boxModel) {

		txtFrom.setText(mail);
		txtFrom.setEditable(false);

		cmbTo.setModel(boxModel);
	}

	private void actionRun() {

		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				
				MailEvent me = new MailEvent(this);
				
				
				me.setSender(txtFrom.getText());
				me.setReciver(cmbTo.getSelectedItem().toString());
				me.setText(txtMail.getText());
				
				
				mailEA.storeMail(me);
				
				cmbTo.setSelectedItem(txtFrom.getText());

				txtFrom.setText("");
				
				txtMail.setText("");
					

				}

			
		});

	}

	public void setMailListener(MailEventAction mea) {

		mailEA = mea;
	}

	private void createComps() {

		panel = new JPanel();
		txtFrom = new JTextField(10);
		cmbTo = new JComboBox<>();
		cmbModel = new DefaultComboBoxModel<>();
		cmbModel.addElement("Selection... ");
		cmbTo.setModel(cmbModel);

		txtMail = new JTextArea(30, 30);
		scroll = new JScrollPane(txtMail, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		btnSend = new JButton("Send");
		
	}

	private void layoutRun() {

		setLayout(new BorderLayout());

		GridBagConstraints gc = new GridBagConstraints();

		panel.setLayout(new GridBagLayout());

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0.1;
		// gc.weighty=1.0;

		gc.anchor = gc.FIRST_LINE_END;
		gc.insets = new Insets(20, 20, 5, 5);

		panel.add(new JLabel("From: "), gc);

		gc.gridx = 1;
		gc.gridy = 0;

		gc.weightx = 1.0;
		gc.ipadx = 200;

		gc.anchor = gc.FIRST_LINE_START;

		panel.add(txtFrom, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 0.1;
		gc.gridwidth = 1;
		gc.ipadx = 1;
		gc.insets = new Insets(5, 20, 20, 5);

		gc.anchor = gc.FIRST_LINE_END;

		panel.add(new JLabel("To: "), gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridwidth = 5;
		gc.weightx = 1.0;
		gc.ipadx = 200;

		gc.anchor = gc.FIRST_LINE_START;

		panel.add(cmbTo, gc);

		gc.gridx = 0;
		gc.gridy = 2;

		gc.weighty = 1.0;
		gc.gridwidth = 10;
		gc.gridheight = 10;
		gc.insets = new Insets(5, 20, 20, 5);
		gc.fill = gc.BOTH;
		gc.anchor = gc.FIRST_LINE_END;

		panel.add(scroll, gc);

		gc.gridx = 10;
		gc.gridy = 2;
		gc.weightx = 0.1;
		gc.gridwidth = 1;
		gc.ipadx = 1;
		gc.insets = new Insets(5, 20, 20, 20);
		gc.anchor = gc.SOUTHEAST;
		gc.fill = gc.NONE;

		panel.add(btnSend, gc);

		add(panel, BorderLayout.CENTER);

	}

}
