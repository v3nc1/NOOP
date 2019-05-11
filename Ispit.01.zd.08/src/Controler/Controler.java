package Controler;

import java.util.ArrayList;
import java.util.Map;

import GUI.MailEvent;
import Model.User;
import Model.UserDB;

public class Controler {

	User user;
	UserDB db = new UserDB();

	public void newUser(String name, String mail, int id) {

		user = new User(name, mail, id);

		db.storeUser(user);

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

		db.storeUser(user);
	}

	

	public void addSentMail(User us, String mail) {

		us.addSentMail(mail);

	}

	public void addRecivedMail(User us, String mail) {

		us.addRecivedMail(mail);

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
