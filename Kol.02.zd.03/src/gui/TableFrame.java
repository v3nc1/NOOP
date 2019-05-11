package gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Customer;

public class TableFrame extends JFrame {
	
	private JTable customerTable;
	private CustomerTableModel customerTableModel;
	private JPanel tablePanel;
	
	
	public TableFrame() {
		
		super("Table data");
		tablePanel = new JPanel();
		setLayout(new BorderLayout());
		add(tablePanel,BorderLayout.CENTER);
		createComponents();
		setSize(500, 400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void createComponents() {
		
		customerTableModel = new CustomerTableModel();
		customerTable = new JTable(customerTableModel);
		
		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(new JScrollPane(customerTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		
	}
	
	public void refreshTable() {
		customerTableModel.fireTableDataChanged();
	}
	
	public void setTableData(List<Customer> customers) {
		customerTableModel.setTableData(customers);
	}
	

}
