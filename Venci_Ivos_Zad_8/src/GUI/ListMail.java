package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ListMail extends JDialog implements MailEventAction {

	private JPanel pTop;
	private JPanel pMid;
	private JPanel pBot;
	private JTextField txtMail;
	private JTextArea txtArea;
	private JScrollPane scroll;
	private JButton btnClose;

	public ListMail(JFrame frame) {

		super(frame, "All mails", false);

		setVisible(true);
		setSize(300, 300);
		setResizable(false);
		createComps();
		layoutRun();
		activateRun();

	}
	
	private void activateRun() {
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				
				txtArea.setText("");
				txtMail.setText("");
				
			}
		});
		
		
		
	}
	private void createComps() {

		pTop = new JPanel();
		pMid = new JPanel();
		pBot = new JPanel();
		txtMail = new JTextField(10);
		txtArea = new JTextArea(10, 20);
		scroll = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		btnClose = new JButton("Close");

	}

	private void layoutRun() {

		FlowLayout fl = new FlowLayout();
		setLayout(fl);

		pTop.setLayout(fl);
		pMid.setLayout(fl);

		pTop.add(new JLabel("Mails for: "));

		pTop.add(txtMail);

		pMid.add(scroll);

		pBot.add(btnClose);

		add(pTop);
		add(pMid);
		add(pBot);

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

		txtArea.append("\n-----------Sent mail's-------------------\n");
		for (String st : le.getSentMail()) {
			txtArea.append("\n--------------------\n");
			txtArea.append("\n" + st + "\n");

		}

		txtArea.append("\n----------Recived mail's-----------------\n");

		for (String st : le.getRecivedMail()) {

			txtArea.append("\n--------------------\n");
			txtArea.append("\n" + st + "\n");

		}
	}

}
