package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Customer;

public class CustomerTableModel extends AbstractTableModel {

	private String[] colNames = { "id", "name", "city", "mail" };
	private List<Customer> customers;

	public void setTableData(List<Customer> cst) {

		this.customers = cst;
		System.out.println("Size: " + customers.size());
		for (Customer cust : customers) {
			System.out.println(cust.getID() + " : " + cust.getMail());
		}
	}

	public CustomerTableModel() {

	}

	@Override
	public int getColumnCount() {

		return colNames.length;
	}

	@Override
	public int getRowCount() {

		return  customers.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		 Customer cust = customers.get(row);
		
		 switch(col) {
		 case 0:
		 return cust.getID();
		 case 1:
		 return cust.getName();
		 case 2:
		 return cust.getCity();
		 case 3:
		 return cust.getMail();
		 }

		return null;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}

}
