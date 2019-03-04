package model;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
	
	private List<User> users;
	
	public DataBase() {
		
		users=new ArrayList<>();
		
	}
	
	public void addUser(User user) {
		
		users.add(user);
		
	}
	
	public void removeUser(User user) {
		
		users.remove(user);
	}
	
	public List<User> getUsers(){
		
		return users;
	}
}
