import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class MainFrame extends JFrame implements DialogListener {

	private DialogEvent dEvent;
	private JPanel txtPanel;
	private JPanel formPanel;
	private JTextArea usr1TxtAr;
	private JTextArea usr2txtAr;
	private JTextArea comTxtAr;
	private JButton btnSend1;
	private JButton btnSend2;
	private JButton btnNewUser;
	private JScrollPane scroll;
	private UserDialog userD;
	private User user1;
	private User user2;

	public MainFrame() {

		createComp();
		layoutComp();
		activateAll();

	}

	private void createComp() {

		setVisible(true);
		setSize(800, 700);

		// pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		comTxtAr = new JTextArea();
		txtPanel = new JPanel();
		scroll = new JScrollPane(comTxtAr, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		formPanel = new JPanel();
		usr1TxtAr = new JTextArea();
		usr2txtAr = new JTextArea();
		btnSend1 = new JButton("send");
		btnSend2 = new JButton("send");
		btnNewUser = new JButton("New User");
		userD = new UserDialog(new JFrame());
		userD.setVisible(false);

		userD.setDialogListener(this);
		// userD=new UserDialog(this);
		// dEvent=new DialogEvent(this);

	}

	private void layoutComp() {

		// Dimension dim1=new Dimension(200, 100);

		// Dimension dim2=new Dimension(400, 200);

		scroll.setPreferredSize(new Dimension(300, 300));
		setLayout(new BorderLayout());
		formPanel.setLayout(new GridBagLayout());

		txtPanel.setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		formPanel.setPreferredSize(new Dimension(100, 300));

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weighty = 1.0;
		gc.weightx = 1.0;
		// gc.gridheight=10;
		gc.anchor = gc.NORTH;
		gc.fill = gc.BOTH;

		txtPanel.add(scroll, gc);

		gc.gridx = 0;
		gc.gridy = 11;
		// gc.weighty=1.0;
		// gc.weightx=1.0;
		// gc.gridheight=1;
		// gc.gridwidth=1;
		gc.anchor = gc.SOUTH;
		// gc.fill=gc.HORIZONTAL;

		txtPanel.add(btnNewUser, gc);

		setBorders();

		gc.gridx = 0;
		gc.gridy = 0;
		// gc.weightx=0.1;
		// gc.weighty=0.1;
		gc.gridwidth = 10;
		gc.gridheight = 1;

		gc.insets = new Insets(20, 20, 20, 20);

		gc.anchor = gc.EAST;

		formPanel.add(usr1TxtAr, gc);

		gc.gridx = 11;
		gc.gridy = 0;
		// gc.weightx=0.1;
		// gc.weighty=0.1;
		gc.gridwidth = 10;
		gc.gridheight = 1;
		gc.anchor = gc.WEST;
		gc.insets = new Insets(20, 20, 20, 20);

		formPanel.add(usr2txtAr, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.1;
		gc.gridwidth = 4;
		gc.anchor = gc.SOUTHWEST;
		gc.fill = gc.NONE;

		formPanel.add(btnSend1, gc);

		gc.gridx = 11;
		gc.gridy = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.1;
		gc.gridwidth = 4;
		gc.anchor = gc.SOUTHWEST;
		gc.fill = gc.NONE;

		formPanel.add(btnSend2, gc);

		add(txtPanel, BorderLayout.NORTH);
		add(formPanel, BorderLayout.CENTER);

	}

	private void setBorders() {

		Border title = BorderFactory.createTitledBorder("Komunikacija");
		Border frame = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		formPanel.setBorder(BorderFactory.createCompoundBorder(title, frame));

	}

	private void activateAll() {

		btnNewUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				userD.setVisible(true);

			}
		});

		

		

		btnSend1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				comTxtAr.append(user1.getName()+":"+"\n"+usr1TxtAr.getText()+"\n//////////////////////\n");
				
				usr1TxtAr.setText("");
				
			}
		});
		
		btnSend2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comTxtAr.append(user2.getName()+":"+"\n"+usr2txtAr.getText()+"\n//////////////////////\n");
				usr2txtAr.setText("");
			}
		});

	}

	

	@Override
	public void dialogEventOccured(DialogEvent de) {

		
		if(user1 == null) {
			user1 = new User(de.getUserName(), de.getId());
		}else {
			user2=new User(de.getUserName(), de.getId());
		}

	}

}
