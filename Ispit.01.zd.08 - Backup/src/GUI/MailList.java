package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MailList extends JDialog implements MailEventAction{
	
	private JPanel topPanel;
	private JPanel midPanel;
	
	private JLabel label;
	private JTextArea txtList;
	private JTextField txtMail;
	private JButton bttnClose;
	private JScrollPane scroll;
	
	
	
	public MailList(JFrame fr) {
		
		super(fr,"All Mails ",false);
		createComps();
		action();
		
	}
	
	
	private void action() {
		
		bttnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				
				txtMail.setText("");
				txtList.setText("");
				
			}
		});
	}
	
	private void createComps() {
		
		setVisible(false);
		setSize(400, 400);
		setResizable(false);
		
		setLayout(new BorderLayout());
		
		topPanel=new JPanel();
		midPanel=new JPanel();
		label=new JLabel("Mails for: ");
		txtList=new JTextArea(20,20);
		txtMail=new JTextField(15);
		bttnClose=new JButton("Close");
		scroll=new JScrollPane(txtList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		topPanel.setLayout(new GridBagLayout());
		midPanel.setLayout(new GridBagLayout());
		GridBagConstraints gc=new GridBagConstraints();
		
		gc.gridx=0;
		gc.gridy=0;
		gc.weightx=0.5;
		gc.weighty=1.0;
		gc.anchor=gc.FIRST_LINE_START;
		gc.insets=new Insets(30, 30, 30, 0);
		topPanel.add(label,gc);
		
		gc.gridx=1;
		gc.gridy=0;
		gc.gridwidth=3;
		gc.weightx=0.5;
		gc.weighty=1.0;
		gc.insets=new Insets(30, 0, 0,30);
		gc.anchor=gc.FIRST_LINE_START;
		
		topPanel.add(txtMail,gc);
		
		
		gc.gridx=0;
		gc.gridy=1;
		gc.gridwidth=4;
		gc.weightx=0.5;
		gc.weighty=1.0;
		gc.ipadx=1;
		gc.insets=new Insets(0, 20, 0, 20);
		gc.anchor=gc.LINE_START;
		gc.fill=gc.BOTH;
		midPanel.add(scroll,gc);
		
		gc.gridx=1;
		gc.gridy=2;
		gc.weightx=0.1;
		gc.weighty=0.1;
		gc.gridwidth=1;
		//gc.ipadx=1;
		gc.anchor=gc.CENTER;
		gc.fill=gc.NONE;
		midPanel.add(bttnClose,gc);
		
	
		
		add(topPanel,BorderLayout.NORTH);
		add(midPanel,BorderLayout.CENTER);
		
		
		
		
		
		
		
		
		
	}


	@Override
	public void storeMail(MailEvent me) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void listMail(ListEvent le) {
		
		setVisible(true);
		
		txtMail.setText(le.getUser());
		
		txtMail.setEditable(false);
		
		txtList.append("-----------Sent mail's-------------------\n");
		for(String st:le.getSentMail()) {
			txtList.append(st+"\n");
			
		}
		
		txtList.append("----------Recived mail's-----------------\n");
		
		for(String st:le.getRecivedMail()) {
			txtList.append(st+"\n");
			
		}
		
		
	}

}
