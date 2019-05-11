package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserDB implements Serializable{
	
	private ArrayList<User> dbUser=new ArrayList<>();
	
	
	public UserDB() {
		
	}

	public ArrayList<User> getDb() {
		return dbUser;
	}
	
	public void storeUser(User user) {
		
		dbUser.add(user);
	}

	
	
}
