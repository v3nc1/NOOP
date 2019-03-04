package GUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.User;

public class TableModel extends AbstractTableModel {
	
	private List<User> db;
	private String[] colNames= {"ID","Name","Mail","Employed","Education","Region"};
	
	
	public void setData(List<User> dataBase) {
		
		db=dataBase;
		
	}

	@Override
	public String getColumnName(int column) {
		
		
		return colNames[column];
	}

	@Override
	public int getColumnCount() {
		
		return 6;
	}

	@Override
	public int getRowCount() {
		
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		switch(col) {
		case 0: return db.get(row).getId();
		
		case 1: return db.get(row).getName();
		
		case 2: return db.get(row).getMail();
		
		case 3: return db.get(row).getEmployment();
		
		case 4: return db.get(row).getEducation();
		
		case 5: return db.get(row).getRegion();
		
		
		}
		return null;
	}

}
