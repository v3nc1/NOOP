package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class DBase implements Serializable {
	
	private ArrayList<User> db;
	
	public DBase() {
		
		db=new ArrayList<>();
		
	}

	public DBase(ArrayList<User> db) {
		
		this.db = db;
	}

	public ArrayList<User> getDb() {
		return db;
	}

	public void addUser(User us) {
		db.add(us);
	}
	
	
	
	
	

}
