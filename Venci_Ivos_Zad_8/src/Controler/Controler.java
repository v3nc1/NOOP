package Controler;

import java.util.ArrayList;

import Model.DBase;
import Model.User;

public class Controler {
	
	private User user;
	private DBase db=new DBase();
	
	
	public Controler() {
		
		
	}
	


	public void newUser(String name, String mail, int id) {

		user = new User(name, mail, id);

		db.addUser(user);

	}


	public ArrayList<String> getSentList(User us) {

		return us.getSentMail();
	}

	public ArrayList<String> getRecivedList(User us) {

		
		return us.getRecivedMail();
	}

	public String getName(User user) {
		return user.getName();
	}

	public String getMail(User user) {
		return user.getMail();
	}

	public int getId() {
		return user.getId();
	}


	public ArrayList<User> getDb() {
		return db.getDb();
	}

	public void addUsers(User user) {

		db.addUser(user);
	}

	

	public void addSentMail(User user, String mail) {
		
		user.addSentMail(mail);

	}

	public void addRecivedMail(User user, String mail) {

		user.addRecivedMail(mail);

	}

	public User getUser(String mail) {

		for (User u : db.getDb()) {

			if (u.getMail().equals(mail)) {

				return u;
			}

		}
		return null;
	}

	

}
