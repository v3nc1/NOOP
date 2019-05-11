package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import controller.Controller;
import model.Customer;
import model.Order;

public class MainFrame extends JFrame {

	private TextPanel txtPanel;
	private ToolBar tlbar;
	private ToolBarListener tListener;
	private FormPanel fPanel;
	private MenuBar menuBar;
	private Controller cntrl;
	private TableFrame tableFrame;


	public MainFrame() {

		setLayout(new BorderLayout());

		createCompMainFrame();
		add(fPanel, BorderLayout.SOUTH);
		add(txtPanel, BorderLayout.CENTER);
		add(tlbar, BorderLayout.NORTH);
		tlbar.setToolBarListener(tListener);
		setJMenuBar(menuBar.getJMenuBar());
		menuBar.setMainFrame(MainFrame.this);
		setSize(750, 600);
		Dimension mins = new Dimension(700, 550);
		setMinimumSize(mins);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public void createCompMainFrame() {
		
		txtPanel = new TextPanel();		
		tlbar = new ToolBar();
		fPanel = new FormPanel();
		menuBar = new MenuBar();
		cntrl = new Controller();
		TableFrame tableFrame = new TableFrame();
		tListener = new ToolBarListener() {

			@Override
			public void setTextFromFile(String text) {

				txtPanel.writeText(text);

			}

			@Override
			public void clearAllText() {

				txtPanel.clearTextArea();

			}

			@Override
			public void listAllCustomers() {
				cntrl.listAllCustomers();

			}

			@Override
			public void listCustomers() {
				
				
				for (Customer c:cntrl.getData()) {
						System.out.println(c.getID());
					txtPanel.writeText("\n///////////////////// Customer "+c.getID()+" //////////////////////\n"+
					cntrl.gName(c) + " : " + cntrl.gCity(c) + " : " + cntrl.gMail(c));
					
				}
			}

			@Override
			public void listOrders() {
				
				for (Order c:cntrl.getOrderData()) {
				txtPanel.writeText("\n///////////////////// Orders  //////////////////////\n"+
					cntrl.getDelivery(c) + " \n " + cntrl.getProductCat(c) + " \n " + cntrl.getPaymentMet(c) + "\n" +
						cntrl.getGcText(c)+"\n"+ cntrl.isDecorativePack(c)+"\n"+cntrl.isGiftCard(c)+"\n"+cntrl.isNewLetter(c));
				}
			}
		};

		fPanel.setFormListener(new FormListener() {

			@Override
			public void leftPanelEventOccured(LeftFormEvent lfe) {

				String city = lfe.getCity();
				String mail = lfe.getMail();
				String name = lfe.getName();
				int counter = lfe.getNumClicked();

				txtPanel.writeText(name + " : " + city + " : " + mail);
				cntrl.addCustomerData(lfe);

				if (counter == 1) {
					
					tableFrame.setTableData(cntrl.getData());
					tableFrame.setVisible(true);
					tableFrame.refreshTable();

				} else {
					
					tableFrame.setTableData(cntrl.getData());
					tableFrame.refreshTable();

				}

			}

			@Override
			public void rightPanelEventOccured(RightFormEvent rfe) {

				int productCat = rfe.getProducrCat();
				boolean giftCard = rfe.isGiftCard();
				boolean decorativePack = rfe.isDecorativePack();
				boolean newLetter = rfe.isNewLetter();
				String paymentMet = rfe.getPaymentMet();
				String gcText = rfe.getGcText();
				String delivery = rfe.getDelivery();
				
				cntrl.addOrderData(rfe);
				
				txtPanel.writeText("\n///////////////////// Orders  //////////////////////\n"+
						delivery + " \n " + productCat + " \n " + paymentMet + "\n" +
							gcText+"\n"+ decorativePack+"\n"+giftCard+"\n"+newLetter);
					

				System.out.println("Kategorija proizvoda: " + productCat);
				System.out.println("Gift card: " + giftCard);
				System.out.println("Gift card short text: " + gcText);
				System.out.println("Decorative package: " + decorativePack);
				System.out.println("Send me newsletters: " + newLetter);
				System.out.println("Payment method: " + paymentMet + ", delivery: " + delivery);

			}
		});

	}
	public List<Customer> getData(){
		
		return cntrl.getData();
	}
	
	public List<Order> getOrderData(){
		
		return cntrl.getOrderData();
	}
	
	public void populateList(ArrayList<Customer> lista) {
		
		cntrl.addData(lista);
	}
	
	public void populateOrderList(ArrayList<Order> lista) {
		
		cntrl.addOredrData(lista);
	}
	
	public void listItems() {
		
		cntrl.listAllCustomers();
		txtPanel.writeText(cntrl.listCustomers());
	}
	
	public void listOrders() {
		
		//txtPanel.writeText(cntrl.l);
	}
	
	

}
