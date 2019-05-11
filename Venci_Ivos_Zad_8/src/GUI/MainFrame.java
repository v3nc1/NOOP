package GUI;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controler.Controler;
import Model.User;

public class MainFrame extends JFrame implements MailEventAction{

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem save;
	private JMenuItem open;
	private JMenuItem exit;
	private JTextField txtName;
	private JTextField txtMail;
	private JTextField txtId;
	private JButton btnConfirm;
	private JComboBox cmbMail;
	private DefaultComboBoxModel cmbBoxModel;
	private JButton btnCompose;
	private JButton btnListMail;
	private JPanel pLeft;
	private JPanel pRight;
	private JPanel pTop;
	private Controler ctrl;
	private NewMail mailWindow;
	private JFileChooser chooser;
	private FileNameExtensionFilter filter;
	private ListMail listM;
	
	private MailEventAction mEvAc;
	
	

	public MainFrame() {

		setTitle("Main window");
		setVisible(true);
		setSize(600, 400);
		setResizable(false);
		createComps();
		layoutRun();
		actionRun();

	}
	
	private void actionRun() {
		
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ctrl.newUser(txtName.getText(), txtMail.getText(), Integer.parseInt(txtId.getText()));
				
				cmbBoxModel.addElement(ctrl.getMail(ctrl.getUser(txtMail.getText())));
				
				cmbBoxModel.setSelectedItem(ctrl.getMail(ctrl.getUser(txtMail.getText())));
				
				txtId.setText("");
				txtMail.setText("");
				txtName.setText("");
				
				
			}
		});
		
		btnCompose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				

				mailWindow.setVisible(true);
				mailWindow.setMail(cmbBoxModel.getSelectedItem().toString(), cmbBoxModel);
				mailWindow.setMailListener(mEvAc);
				btnListMail.setEnabled(true);
				
			}
		});
		
		btnListMail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				ListEvent le = new ListEvent(this);
				
				
				le.setUser(ctrl.getUser(cmbMail.getSelectedItem().toString()).getMail());

				le.setSentMail(ctrl.getSentList(ctrl.getUser(cmbMail.getSelectedItem().toString())));

				le.setRecivedMail(ctrl.getRecivedList(ctrl.getUser(cmbMail.getSelectedItem().toString())));
				
				listM.listMail(le);
				
				
			}
		});
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int opt = chooser.showSaveDialog(new JFrame());

				if (opt == JFileChooser.APPROVE_OPTION) {

					saveUser();

				}
				
			}
		});
		
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int opt = chooser.showOpenDialog(new JFrame());

				if (opt == JFileChooser.APPROVE_OPTION) {

					openUser();

				}
			}
		});
		
	}
	public void saveUser() {

		try (ObjectOutputStream oOut = new ObjectOutputStream(
				new FileOutputStream(chooser.getSelectedFile() + ".usr"))) {

			oOut.writeObject(ctrl.getDb());

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

				ctrl.addUsers(u);
				cmbBoxModel.addElement(ctrl.getMail(u));
				cmbBoxModel.setSelectedItem(ctrl.getMail(u));
			}

			System.out.println("Users added successfully...");
			btnListMail.setEnabled(true);;

		} catch (Exception e) {

			System.out.println("No User DataBase....");
		}

	}

	private void createComps() {
		
		ctrl=new Controler();
		menuBar = new JMenuBar();
		menu = new JMenu("File Menu");
		save = new JMenuItem("Save as...");
		open = new JMenuItem("Open...");
		exit = new JMenuItem("Exit");
		pLeft = new JPanel();
		pRight = new JPanel();
		pTop=new JPanel();
		menu.add(save);
		menu.add(open);
		menu.add(exit);
		menuBar.add(menu);
		txtName = new JTextField(10);
		txtMail = new JTextField(10);
		txtId = new JTextField(10);
		btnConfirm = new JButton("Confirm");
		cmbMail = new JComboBox<>();

		cmbBoxModel = new DefaultComboBoxModel<>();
		
		cmbBoxModel.addElement("Selection...");
		cmbMail.setModel(cmbBoxModel);
		btnCompose = new JButton("Compose mail");
		btnListMail = new JButton("List all mails");
		
		btnListMail.setEnabled(false);
		mailWindow=new NewMail(new JFrame());
		mailWindow.setVisible(false);
		mailWindow.setMailListener(this);
		listM=new ListMail(new JFrame());
		listM.setVisible(false);
		setListListener(this);
		chooser=new JFileChooser();
		filter = new FileNameExtensionFilter("user Database", "usr");
		chooser.setFileFilter(filter);
		

	}

	private void layoutRun() {

		setLayout(new BorderLayout());
		
		add(menuBar,BorderLayout.NORTH);
		
		
		GridBagConstraints gc = new GridBagConstraints();

		pLeft.setLayout(new GridBagLayout());

		borderLeftSet();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets=new Insets(20, 10, 20, 10);
		gc.anchor = gc.LINE_START;

		pLeft.add(new JLabel("User Name"), gc);

		gc.gridx = 1;

		pLeft.add(txtName, gc);

		gc.gridx = 0;
		gc.gridy = 1;

		pLeft.add(new JLabel("Mail address: "), gc);

		gc.gridx = 1;

		pLeft.add(txtMail, gc);

		gc.gridx = 0;
		gc.gridy = 2;

		pLeft.add(new JLabel("User id: "), gc);

		gc.gridx = 1;

		pLeft.add(txtId, gc);

		gc.gridy = 3;
		gc.gridx = 0;

		pLeft.add(btnConfirm, gc);

		add(pLeft,BorderLayout.WEST);

		pRight.setLayout(new GridBagLayout());
		borderRightSet();

		gc.gridx = 0;
		gc.gridy = 0;
		
		gc.anchor = gc.LINE_START;
		
		pRight.add(new JLabel("Select mailbox: "),gc);
		
		gc.gridy = 1;
		
		pRight.add(cmbMail, gc);
		
		gc.gridy=2;
		
		pRight.add(btnCompose, gc);
		
		gc.gridy=3;
		
		pRight.add(btnListMail, gc);
		
		add(pRight,BorderLayout.CENTER);

	}

	private void borderLeftSet() {

		Border top = BorderFactory.createTitledBorder("New mailBox");
		Border bott = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		pLeft.setBorder(BorderFactory.createCompoundBorder(top, bott));

	}

	private void borderRightSet() {

		Border top = BorderFactory.createTitledBorder("Communication");
		Border bott = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		pRight.setBorder(BorderFactory.createCompoundBorder(top, bott));

	}
	
	private void setListListener(MailEventAction mea) {
		
		mEvAc=mea;
	}

	@Override
	public void storeMail(MailEvent me) {
		
		
		ctrl.addSentMail(ctrl.getUser(me.getSender()), "To: " + me.getReciver() + "\n" + me.getText());
		ctrl.addRecivedMail(ctrl.getUser(me.getReciver()),"From: " + me.getSender() + "\n" + me.getText());
		
	}

	@Override
	public void listMail(ListEvent le) {
		
		
		
	}

}
