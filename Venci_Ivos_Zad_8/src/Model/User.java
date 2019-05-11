package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	
	private String name;
	private String mail;
	private int id;
	private ArrayList<String> sentMail;
	private ArrayList<String> recivedMail;

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

	public void addSentMail(String mail) {
		
		System.out.println(mail);
		sentMail.add(mail);

	}

	public void addRecivedMail(String mail) {

		recivedMail.add(mail);

	}

	public ArrayList<String> getSentMail() {
		return sentMail;
	}

	public ArrayList<String> getRecivedMail() {
		return recivedMail;
	}
	
	

	
	

}
