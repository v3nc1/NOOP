package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class DataBase implements Serializable{
	
	ArrayList<User> userList;
	
	
	public DataBase() {
		
		userList=new ArrayList<>();
		
	}


	public ArrayList<User> getUserList() {
		return userList;
	}


	public void setUserList(User usr) {
		
		userList.add(usr);
	}
	
	public ArrayList<User> listUsers() {
		
		return userList;
	}
	
	public void show() {
		
		for (User u:userList) {
			
			System.out.println("Br: "+u.getNO()+"\nID: "+u.getId()+"\nName: "+u.getName()+"\n");
		}
	}
	
	
	
	

}
