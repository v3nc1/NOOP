package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.User;


public class TablePanel extends JPanel {
	
	private JTable table;
	private TableModel tableModel;
	
	
	public TablePanel() {
		
		
		setLayout(new BorderLayout());
		Dimension dim=getPreferredSize();
		dim.width=350;
		setPreferredSize(dim);
		runCreate();
		runLayout();
	
	}
	
	public void inputDataBase(List<User> dataBase) {
		
		tableModel.setData(dataBase);
		
		
		
	}
	
	private void runCreate() {
		
		
		tableModel=new TableModel();
		table=new JTable(tableModel);
		
		
	}
	
	private void runLayout() {
		
		add(new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS),BorderLayout.CENTER);
		
		
	}
	
	public void refresh() {
		
		tableModel.fireTableDataChanged();
	}
	
	
	
	
	
	
}
