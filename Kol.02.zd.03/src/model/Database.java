package model;

import java.util.ArrayList;
import java.util.List;

public class Database {
	
	private ArrayList<Customer> customers;
	private ArrayList<Order> order;
	
	public Database() {
		customers = new ArrayList<>();
		order = new ArrayList<>();
	}
	
	public void addCustomer(Customer cst) {
		customers.add(cst);
	}
	
	public void addOrder(Order ord) {
		
		order.add(ord);
		
	}
	
	public ArrayList<Customer> getCustomers () {
		
		return customers;
	}
	
	public ArrayList<Order> getOrders(){
		
		return order;
	}

}
