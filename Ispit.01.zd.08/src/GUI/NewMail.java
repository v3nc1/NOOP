package GUI;


import java.awt.BorderLayout;
import java.awt.Dimension;
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
	
	private JPanel topPanel;
	private JPanel bottomPanal;
	private JLabel lblFrom;
	private JLabel lblTo;
	private JTextField txtFrom;
	private JComboBox comboTo;
	private DefaultComboBoxModel comboModel;
	private JTextArea mail;
	private JButton bttnSend;
	private JScrollPane scroll;
	private MailEventAction mea;
	
	

	public NewMail(JFrame fr) {
		
		super(fr,"New mail",false);
		
		setVisible(false);
		setSize(new Dimension(700, 400));
		createComps();
		createLayout();
		action();
		
	}
	
	
	public void setMail(String sender, DefaultComboBoxModel lista) {
		
		txtFrom.setText(sender);
		txtFrom.setEditable(false);
	
		comboTo.setModel(lista);
	}
	
	private void action() {
		
		bttnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				if(mail.getText().equals("")) {
					
					
					JOptionPane.showMessageDialog(null, "Mail can't be empty", "Error", JOptionPane.WARNING_MESSAGE);
				}else {
				setVisible(false);
				MailEvent me=new MailEvent(this);
				
				
				me.setSender(txtFrom.getText());
				
				me.setReciver(comboTo.getSelectedItem().toString());
				
				me.setText(mail.getText());
				
				
				mea.storeMail(me);
				
				comboTo.setSelectedItem(txtFrom.getText());
				
				txtFrom.setText("");
				mail.setText("");
				
				}
				
			}
		});
	}
	
	public void setMailEvent(MailEventAction m) {
		
		mea=m;
		
		
	}
	
	private void createComps() {
		
		topPanel=new JPanel();
		bottomPanal=new JPanel();
		lblFrom=new JLabel("From: ");
		lblTo=new JLabel("To: ");
		txtFrom=new JTextField(10);
		comboTo=new JComboBox<>();
		comboModel=new DefaultComboBoxModel<>();
		mail=new JTextArea(20,20);
		scroll=new JScrollPane(mail, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		bttnSend=new JButton("Send");
		
		
		
	}
	
	private void createLayout() {
		
		setLayout(new BorderLayout());
		
		topPanel.setLayout(new GridBagLayout());
		bottomPanal.setLayout(new GridBagLayout());
		GridBagConstraints gc=new GridBagConstraints();
		
		
		/// ROW 1 ///
		
		gc.gridx=0;
		gc.gridy=0;
		gc.weightx=0.1;
		//gc.weighty=1.0;
		
		gc.anchor=gc.FIRST_LINE_END;
		gc.insets=new Insets(20, 20, 5, 5);
		
		topPanel.add(lblFrom,gc);
		
		gc.gridx=1;
		gc.gridy=0;
		//gc.gridwidth=5;
		gc.weightx=1.0;
		gc.ipadx=200;
		
		//gc.fill=gc.HORIZONTAL;
		gc.anchor=gc.FIRST_LINE_START;
		
		topPanel.add(txtFrom,gc);
		
		
		/// ROW 2 ///
		
		gc.gridx=0;
		gc.gridy=1;
		gc.weightx=0.1;
		gc.gridwidth=1;
		gc.ipadx=1;
		gc.insets=new Insets(5, 20, 20, 5);
		
		gc.anchor=gc.FIRST_LINE_END;
		
		topPanel.add(lblTo,gc);
		
		
		gc.gridx=1;
		gc.gridy=1;
		gc.gridwidth=5;
		gc.weightx=1.0;
		gc.ipadx=200;
		//gc.fill=gc.HORIZONTAL;
		gc.anchor=gc.FIRST_LINE_START;
		
		topPanel.add(comboTo,gc);
		
		/// Bottom ROW ///
		
		gc.gridx=0;
		gc.gridy=2;
		
		gc.weighty=1.0;
		gc.gridwidth=10;
		gc.gridheight=10;
		gc.insets=new Insets(5, 20, 20, 5);
		gc.fill=gc.BOTH;
		gc.anchor=gc.FIRST_LINE_END;
		
		topPanel.add(scroll,gc);
		
		gc.gridx=10;
		gc.gridy=2;
		gc.weightx=0.1;
		gc.gridwidth=1;
		gc.ipadx=1;
		gc.insets=new Insets(5, 20, 20, 20);
		gc.anchor=gc.SOUTHEAST;
		gc.fill=gc.NONE;
		
		topPanel.add(bttnSend,gc);
		
		
		//add(bottomPanal,BorderLayout.CENTER);
		add(topPanel,BorderLayout.CENTER);
		
		
	}

}
