package Controler;

import java.util.ArrayList;

import GUI.DialogEvent;
import Model.DataBase;
import Model.User;

public class Controler {
	
	private int br;
	private User user1;
	private User user2;
	private DataBase db= new DataBase();
	
	
	public void newUser1(DialogEvent de) {
		
		String name=de.getUserName();
		int iD=de.getId();
		br++;
		
		user1 = new User(name,iD,br);
		
		db.setUserList(user1);
		
	}
	
	public void newUser2(DialogEvent de) {
		
		String name=de.getUserName();
		int iD=de.getId();
		br++;

		user2 = new User(name,iD,br);

		db.setUserList(user2);


	}
	
	public String getName1() {
		
		
		
		return user1.getName();
	}
	
	public String getName2() {

		

		return user2.getName();
	}
	
	public int getID1(User usr) {
		
		user1=usr;
		
		return user1.getId();
		
	}
	
	public int getID2(User usr) {
		
		user2=usr;
		
		return user2.getId();
		
	}
	
	
	public int getNO1(User usr) {
	
		user1=usr;
		
		return user1.getNO();
				
	}
	
	public int getNO2(User usr) {
		
		user2=usr;
		
		return user2.getNO();
				
	}
	
	public ArrayList<User> listUsers() {
		
		return db.listUsers();
	}
	
	public void populateUsers(ArrayList<User> us) {
		
		for(User u:us) {
			
			db.setUserList(u);
			
		}
	}
	
	public void showUsers() {
		
		db.show();
	}
	
	public void setUsers() {
		int switcher=1;
		
		for (int i=0;i<db.getUserList().size();i++) {
			
			if(switcher==1) {
			user1=db.getUserList().get(i);
				switcher=0;
			}else {
				
				switcher=1;
				user2=db.getUserList().get(i);
			}
			
			
		}
	}


}
