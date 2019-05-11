package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class User implements Serializable {

	private String name;
	private String mail;
	private int id;
	private ArrayList<Mail> sentMail;
	private ArrayList<Mail> recivedMail;

	public User(String name, String mail, int id) {
		super();
		this.name = name;
		this.mail = mail;
		this.id = id;
		sentMail = new ArrayList<>();
		recivedMail = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getMail() {
		return mail;
	}

	public int getId() {
		return id;
	}

	public void addSentMail(Mail mail) {

		sentMail.add(mail);

	}

	public void addRecivedMail(Mail mail) {

		recivedMail.add(mail);

	}

	public ArrayList<Mail> getSentMail() {
		return sentMail;
	}

	public ArrayList<Mail> getRecivedMail() {
		return recivedMail;
	}
	
	

}
