package controller;

import java.util.ArrayList;

import gui.LeftFormEvent;
import gui.RightFormEvent;
import model.Customer;
import model.Database;
import model.Order;

public class Controller {

	private Customer cst;
	private Order ord;
	private Database dbs = new Database();
//	private ArrayList<Customer> cList;
//	private ArrayList<Order> ordList;

	public void addCustomerData(LeftFormEvent lfe) {

		String name = lfe.getName();
		String city = lfe.getCity();
		String mail = lfe.getMail();

		cst = new Customer(name, city, mail);
		dbs.addCustomer(cst);

	}
	
	public void addOrderData(RightFormEvent rfe	) {
		
		int productCat = rfe.getProducrCat();
		boolean giftCard = rfe.isGiftCard();
		boolean decorativePack = rfe.isDecorativePack();
		boolean newLetter = rfe.isNewLetter();
		String paymentMet = rfe.getPaymentMet();
		String gcText = rfe.getGcText();
		String delivery = rfe.getDelivery();
		
		ord = new Order(productCat, giftCard, decorativePack, newLetter, paymentMet, gcText, delivery);
		dbs.addOrder(ord);
		
		
	}

	public void listAllCustomers() {

		for (Customer cst : dbs.getCustomers()) {

			System.out.println("///////////////////// Customer //////////////////////");
			System.out.println(cst.getName() + " : " + cst.getCity() + " : " + cst.getMail());

		}
	}
	public String listCustomers() {

		for (Customer cst : dbs.getCustomers()) {

			return "\n///////////////////// Customer //////////////////////\n"+
					cst.getName() + " : " + cst.getCity() + " : " + cst.getMail();

		}
		return null;
		
	}

	public ArrayList<Customer> getData() {
		System.out.println("Returning customer data from database :-)");
		return dbs.getCustomers();
	}
	
	public ArrayList<Order> getOrderData(){
		
		System.out.println("Returning order data from database :-)");
		return dbs.getOrders();
	}
	
	public void addData(ArrayList<Customer> list) {
		
		for (Customer c:list) {
			dbs.addCustomer(c);
		}
	}
	
	public void addOredrData(ArrayList<Order> list) {

		for (Order c:list) {
			dbs.addOrder(c);
		}
	}
	
	
	public String gName(Customer c) {
		
		cst=c;
		
		
		return cst.getName();
	}
	public String gCity(Customer c) {
		
		cst=c;
		
		
		return cst.getCity();
	}
	
	public String gMail(Customer c) {
		
		cst=c;
		
		
		return cst.getMail();
	}
	
	public int getProductCat(Order or) {
		
		ord=or;
		
		return ord.getProductCat();
	}


	public boolean isGiftCard(Order or) {
		
		ord=or;
		return ord.isGiftCard();
	}


	public boolean isDecorativePack(Order or) {
		
		ord=or;
		return ord.isDecorativePack();
	}


	public boolean isNewLetter(Order or) {
		
		ord=or;
		return ord.isNewLetter();
	}


	public String getPaymentMet(Order or) {
		
		ord=or;
		return ord.getPaymentMet();
	}


	public String getGcText(Order or) {
		
		ord=or;
		return ord.getGcText();
	}


	public String getDelivery(Order or) {
		
		ord=or;
		return ord.getDelivery();
	}

}
