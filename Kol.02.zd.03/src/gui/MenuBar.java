package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Customer;
import model.Order;

public class MenuBar {
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenu viewMenu = new JMenu("View");
	private MainFrame mainFrame;
	private JFileChooser fileChooser = new JFileChooser();
	private JFileChooser fileCh2= new JFileChooser();
	public TextPanel txtP=new TextPanel();
	private Customer cust;
	private String str; 
	//private Controller cntler=new Controller();
	//Database db=new Database();
	
	private ArrayList<Customer> custLista;
	private ArrayList<Order> ordLista;
	private JMenuItem open = new JMenuItem("Open...");
	private JMenuItem save = new JMenuItem("Save as...");
	private JMenuItem exit = new JMenuItem("Exit");
	
	FileFilter filter1 = new FileNameExtensionFilter("TXT files", "txt");
	FileFilter filter2 = new FileNameExtensionFilter("PDF files", "pdf");
	FileFilter filter3 = new FileNameExtensionFilter("HTML files", "html");
	FileFilter filter4 = new FileNameExtensionFilter("Word files", new String[] {"doc", "docx"});
	FileFilter filter5=new FileNameExtensionFilter("Customers", "cust");
	FileFilter filter6= new FileNameExtensionFilter("Order", "ord");
	
	
	public MenuBar() {
		
		createMenuBar();
		activateMenuBar();
	}
	
	
	private void createMenuBar() {
		
		menuBar.add(fileMenu);
		menuBar.add(viewMenu);
		
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		fileChooser.addChoosableFileFilter(filter1);
		fileChooser.addChoosableFileFilter(filter2);
		fileChooser.addChoosableFileFilter(filter3);
		fileChooser.addChoosableFileFilter(filter4);
		fileCh2.addChoosableFileFilter(filter5);
		fileCh2.addChoosableFileFilter(filter6);
		fileChooser.setFileFilter(filter1);
		fileChooser.setAcceptAllFileFilterUsed(true);
		fileCh2.setFileFilter(filter5);
		
		
	}
	
	public JMenuBar getJMenuBar() {
		return menuBar;
	}
	
	public void activateMenuBar() {
		
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int val = fileCh2.showOpenDialog(mainFrame);
				
				if(val == JFileChooser.APPROVE_OPTION) {
					
					try(FileInputStream fIn=new FileInputStream(fileCh2.getSelectedFile());
							ObjectInputStream oIn=new ObjectInputStream(fIn);){
						
						String ext="";
						str=fileCh2.getSelectedFile().getName();
						
						ext=str.substring(str.lastIndexOf("."));
						
						//System.out.println("Uèitavam podatke...");
						
						
						if(ext.equals(".cust")) {
						System.out.println("Uèitavam Customer podatke...");
						custLista=(ArrayList<Customer>) oIn.readObject();
						
						mainFrame.populateList(custLista);
						
						
						System.out.println("Podaci o Custemerima uèitani");
						}else if (ext.equals(".ord")) {
							
							System.out.println("Uèitavam Order podatke...");
							ordLista=(ArrayList<Order>) oIn.readObject();
							
							mainFrame.populateOrderList(ordLista);
							
							
						}
						
						
						
					}catch(ClassNotFoundException cn) {
						cn.getMessage();
					}catch(Exception ev) {
					
						ev.getMessage();
					}
					
					
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Canceled by user");
				}
				
			}
		});
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int val = fileCh2.showSaveDialog(mainFrame);
				
				
				if(val == JFileChooser.APPROVE_OPTION) {
					
					if(fileCh2.getFileFilter().getDescription().equals("Customers")) {
					try (FileOutputStream fOut=new FileOutputStream(fileCh2.getSelectedFile()+".cust");
					ObjectOutputStream oOut=new ObjectOutputStream(fOut);){
							
							
						//System.out.println(fileCh2.getFileFilter().getDescription());
						oOut.writeObject(mainFrame.getData());
						 
					}catch(Exception ev) {
						ev.getMessage();
					}
					
				
				}
				else if(fileCh2.getFileFilter().getDescription().equals("Order")) {
					
					try (FileOutputStream fOut=new FileOutputStream(fileCh2.getSelectedFile()+".ord");
							ObjectOutputStream oOut=new ObjectOutputStream(fOut);){
									
									
								//System.out.println(fileCh2.getFileFilter().getDescription());
								oOut.writeObject(mainFrame.getOrderData());
								 
							}catch(Exception ev) {
								ev.getMessage();
							}
					
						} 
				}else {
							JOptionPane.showMessageDialog(mainFrame, "Canceled by user");
						}
					
		}
				
			
		});
		
		
		
		
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int val = JOptionPane.showConfirmDialog(mainFrame, "Really, you want to exit!?", 
						"Exit confirmation", JOptionPane.OK_CANCEL_OPTION);
				
				if(val == JOptionPane.OK_OPTION) {
					System.exit(0);
				} else {
					
					
					JOptionPane.showMessageDialog(mainFrame, "Canceled by user");
					// System.out.println("Canceled by user");
				}
				
			}
		});
		
	}
	
	public void setMainFrame(MainFrame mf) {
		this.mainFrame = mf;
	}
	

}
