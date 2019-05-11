package GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controler.Controler;
import Model.User;

public class MainFrame extends JFrame implements DialogListener {

	private DialogEvent dEvent;
	private JMenuBar menu;
	private JFileChooser fChs;
	private FileNameExtensionFilter filter;
	private JMenu fileMenu;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem exit;
	private JPanel txtPanel;
	private JPanel formPanel;
	private JTextArea usr1TxtAr;
	private JTextArea usr2txtAr;
	private JTextArea comTxtAr;
	private JButton btnSend1;
	private JButton btnSend2;
	private JButton btnNewUser;
	private JButton btnListUsr;
	private JScrollPane scroll;
	private UserDialog userD;
	private Controler ctrl;
	private int switcher=1;
	ArrayList<User> readObject;
	
	

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
		
		menu=new JMenuBar();
		fChs=new JFileChooser();
		filter=new FileNameExtensionFilter("User DB", "usr");
		fileMenu=new JMenu("File");
		open=new JMenuItem("Open...");
		save=new JMenuItem("Save...");
		exit=new JMenuItem("Exit");
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
		btnListUsr=new JButton("List Users");
		userD = new UserDialog(new JFrame());
		userD.setVisible(false);

		userD.setDialogListener(this);
		ctrl=new Controler();
		readObject=new ArrayList<>();
		// userD=new UserDialog(this);
		// dEvent=new DialogEvent(this);

	}

	private void layoutComp() {

		
		menu.add(fileMenu);
		
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		setJMenuBar(menu);
		fChs.addChoosableFileFilter(filter);
		fChs.setFileFilter(filter);
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
		gc.anchor = gc.CENTER;
		// gc.fill=gc.HORIZONTAL;
		txtPanel.add(btnNewUser, gc);
		
		gc.gridx = 0;
		gc.gridy = 12;
		// gc.weighty=1.0;
		// gc.weightx=1.0;
		// gc.gridheight=1;
		// gc.gridwidth=1;
		gc.anchor = gc.SOUTH;
		// gc.fill=gc.HORIZONTAL;

		txtPanel.add(btnListUsr, gc);


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
		
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int to=fChs.showOpenDialog(new JFrame());
				
				if(to==JFileChooser.APPROVE_OPTION) {
					
					try(ObjectInputStream fIn=new ObjectInputStream(new FileInputStream(fChs.getSelectedFile()))){
						
						System.out.println("Uèitavam USERs .....");
						
						readObject = (ArrayList<User>) fIn.readObject();
						
						ctrl.populateUsers(readObject);
						ctrl.setUsers();
						
						System.out.println("Users uèitani");
						
						
						
					}catch (ClassNotFoundException e) {
						
						e.getMessage();
						
					}catch (IOException e) {
					
						
						e.getMessage();
					}
				}
			}
		});
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int to=fChs.showSaveDialog(new JFrame());
				
				if(to==JFileChooser.APPROVE_OPTION) {

					try(ObjectOutputStream oOut=new ObjectOutputStream(
							new FileOutputStream(fChs.getSelectedFile()+".usr"))){
					
						
						
							
							oOut.writeObject(ctrl.listUsers());
							
							
							
						


					}catch(IOException e) {
						
						e.getMessage();
					}
				}

				
				
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
				
			}
		});
		
		btnNewUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				userD.setVisible(true);
				

			}
		});

		
		btnListUsr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				ctrl.showUsers();
				
			}
		});
		

		btnSend1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				comTxtAr.append(ctrl.getName1()+":"+"\n"+"\n>"+usr1TxtAr.getText()+"\n");
				
				usr1TxtAr.setText("");
				
			}
		});
		
		btnSend2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comTxtAr.append(ctrl.getName2()+":"+"\n"+"\n>"+usr2txtAr.getText()+"\n");
				usr2txtAr.setText("");
			}
		});

	}

	

	@Override
	public void dialogEventOccured(DialogEvent de) {

		
		if(switcher == 1) {
			ctrl.newUser1(de);
			switcher=0;
		}else {
			ctrl.newUser2(de);
			switcher=1;
		}
		
		

	}

}
