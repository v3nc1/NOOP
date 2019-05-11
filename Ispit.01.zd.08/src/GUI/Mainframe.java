package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.color.CMMException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controler.Controler;
import Model.User;

public class Mainframe extends JFrame implements MailEventAction {

	private JMenuBar meni;
	private JMenu fileMenu;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem exit;
	private JPanel lPanel;
	private JPanel rPanel;
	private JLabel lblName;
	private JLabel lblMail;
	private JLabel lblID;
	private JLabel lblSelect;
	private JTextField txtName;
	private JTextField txtMail;
	private JTextField txtID;
	private JButton bttConfirm;
	private JButton bttCompose;
	private JButton bttList;
	private JComboBox<String> comboMail;
	private JPanel mainPanel;
	private DefaultComboBoxModel boxModel;
	private NewMail mail;
	private MailList ml;
	private JFileChooser chooser;
	private FileNameExtensionFilter filter;
	private Controler cntrl;
	private ListEvent le;
	private MailEventAction mea;

	public Mainframe() {

		setSize(new Dimension(700, 500));
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createComps();
		addBorderds();
		addLayout();
		activation();
		openDefaultUser();

	}

	private void activation() {

		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int opt = chooser.showOpenDialog(new JFrame());

				if (opt == JFileChooser.APPROVE_OPTION) {

					openUser();

				}

			}
		});

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int opt = chooser.showSaveDialog(new JFrame());

				if (opt == JFileChooser.APPROVE_OPTION) {

					saveUser();

				}

			}
		});

		bttConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				cntrl.newUser(txtName.getText(), txtMail.getText(), Integer.parseInt(txtID.getText()));

				// for(User u:cntrl.getDb()) {

				boxModel.addElement(cntrl.getMail(cntrl.getUser(txtMail.getText())));
				boxModel.setSelectedItem(cntrl.getMail(cntrl.getUser(txtMail.getText())));

				// }

				txtName.setText("");
				txtMail.setText("");
				txtID.setText("");

			}
		});

		bttCompose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				mail.setVisible(true);
				mail.setMail(boxModel.getSelectedItem().toString(), boxModel);

			}
		});

		bttList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ListEvent le = new ListEvent(this);

				le.setUser(cntrl.getUser(comboMail.getSelectedItem().toString()).getMail());

				le.setSentMail(cntrl.getSentList(cntrl.getUser(comboMail.getSelectedItem().toString())));

				le.setRecivedMail(cntrl.getRecivedList(cntrl.getUser(comboMail.getSelectedItem().toString())));

				ml.listMail(le);

			}
		});

	}

	public void saveUser() {

		try (ObjectOutputStream oOut = new ObjectOutputStream(
				new FileOutputStream(chooser.getSelectedFile() + ".usr"))) {

			oOut.writeObject(cntrl.getDb());

			System.out.println("User's saved successfully.");

		} catch (IOException e) {

			System.out.println("Error writing FILE...");
		}

	}

	public void openUser() {

		try (ObjectInputStream oIn = new ObjectInputStream(new FileInputStream(chooser.getSelectedFile()))) {

			ArrayList<User> tempList = new ArrayList<>();

			tempList = (ArrayList<User>) oIn.readObject();

			for (User u : tempList) {

				cntrl.addUsers(u);
				boxModel.addElement(cntrl.getMail(u));
				boxModel.setSelectedItem(cntrl.getMail(u));
			}

			System.out.println("Users added successfully...");

		} catch (Exception e) {

			System.out.println("No User DataBase....");
		}

	}

	public void openDefaultUser() {

		try (ObjectInputStream oIn = new ObjectInputStream(new FileInputStream(".\\user.usr"))) {

			ArrayList<User> tempList = new ArrayList<>();

			tempList = (ArrayList<User>) oIn.readObject();

			for (User u : tempList) {

				cntrl.addUsers(u);
				boxModel.addElement(cntrl.getMail(u));
				boxModel.setSelectedItem(cntrl.getMail(u));
			}

			System.out.println("Users added successfully...");

		} catch (Exception e) {

			System.out.println("No User DataBase....");
		}

	}

	public void createComps() {

		mainPanel = new JPanel();
		lPanel = new JPanel();
		rPanel = new JPanel();
		lblName = new JLabel("UserName: ");
		lblMail = new JLabel("Mail address: ");
		lblID = new JLabel("User ID: ");
		lblSelect = new JLabel("Select mailbox: ");
		txtName = new JTextField(10);
		txtMail = new JTextField(10);
		txtID = new JTextField(10);
		bttConfirm = new JButton("Confirm");
		bttCompose = new JButton("Compose mail");
		bttList = new JButton("List all mails");
		comboMail = new JComboBox<>();
		meni = new JMenuBar();
		fileMenu = new JMenu("File Menu");
		save = new JMenuItem("save..");
		open = new JMenuItem("open..");
		exit = new JMenuItem("exit");

		boxModel = new DefaultComboBoxModel<>();

		mail = new NewMail(new JFrame());
		mail.setMailEvent(this);
		ml = new MailList(new JFrame());

		comboMail.setModel(boxModel);

		boxModel.addElement("Selection..");
		setListEvent(this);
		chooser = new JFileChooser();
		filter = new FileNameExtensionFilter("user Database", "usr");
		cntrl = new Controler();

		chooser.setFileFilter(filter);

	}

	private void setListEvent(MailEventAction m) {

		mea = m;
	}

	private void addLayout() {

		setLayout(new BorderLayout());
		mainPanel.setLayout(new GridLayout(1, 2));

		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.addSeparator();
		fileMenu.add(exit);

		meni.add(fileMenu);

		GridBagConstraints gc = new GridBagConstraints();

		lPanel.setLayout(new GridBagLayout());
		rPanel.setLayout(new GridBagLayout());

		add(meni, BorderLayout.NORTH);

		/// Right panel////

		/// Row 1///

		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(10, 20, 10, 10);
		gc.anchor = gc.FIRST_LINE_START;

		lPanel.add(lblName, gc);

		gc.gridx = 1;
		gc.gridy = 0;

		gc.anchor = gc.FIRST_LINE_START;

		lPanel.add(txtName, gc);

		/// Row 2///

		gc.gridx = 0;
		gc.gridy = 1;

		gc.anchor = gc.FIRST_LINE_START;

		lPanel.add(lblMail, gc);

		gc.gridx = 1;
		gc.gridy = 1;

		gc.anchor = gc.FIRST_LINE_START;

		lPanel.add(txtMail, gc);

		/// Row 3///

		gc.gridx = 0;
		gc.gridy = 2;

		gc.anchor = gc.FIRST_LINE_START;

		lPanel.add(lblID, gc);

		gc.gridx = 1;
		gc.gridy = 2;

		gc.anchor = gc.FIRST_LINE_START;

		lPanel.add(txtID, gc);

		/// Row 4///

		gc.gridx = 0;
		gc.gridy = 3;
		gc.gridwidth = 2;
		gc.anchor = gc.CENTER;

		gc.insets = new Insets(150, 0, 0, 0);
		lPanel.add(bttConfirm, gc);

		mainPanel.add(lPanel);

		/// Right Panel ////

		//// Row 1 ////

		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(10, 10, 10, 10);
		gc.anchor = gc.FIRST_LINE_START;

		rPanel.add(lblSelect, gc);

		/// Row 2 ///

		gc.gridx = 0;
		gc.gridy = 1;

		gc.insets = new Insets(10, 0, 0, 0);
		gc.anchor = gc.FIRST_LINE_START;

		rPanel.add(comboMail, gc);

		/// Row 3 ///

		gc.gridx = 0;
		gc.gridy = 2;

		gc.anchor = gc.CENTER;
		gc.insets = new Insets(20, 0, 10, 0);
		rPanel.add(bttCompose, gc);

		/// Row 4 ///

		gc.gridx = 0;
		gc.gridy = 3;

		gc.insets = new Insets(150, 0, 0, 0);
		gc.anchor = gc.CENTER;

		rPanel.add(bttList, gc);

		mainPanel.add(rPanel);

		add(mainPanel, BorderLayout.CENTER);

	}

	private void addBorderds() {

		Border topLeft = BorderFactory.createTitledBorder("New mailBox");
		Border topRight = BorderFactory.createTitledBorder("Communication");
		Border bott = BorderFactory.createEmptyBorder(0, 0, 0, 0);

		lPanel.setBorder(BorderFactory.createCompoundBorder(topLeft, bott));
		rPanel.setBorder(BorderFactory.createCompoundBorder(topRight, bott));

	}

	@Override
	public void storeMail(MailEvent me) {

		cntrl.addSentMail(cntrl.getUser(me.getSender()), "To: " + me.getReciver() + "\n" + me.getText());

		cntrl.addRecivedMail(cntrl.getUser(me.getReciver()), "From: " + me.getSender() + "\n" + me.getText());
		

		

	}

	@Override
	public void listMail(ListEvent le) {

	}

}