package Model;

import java.io.Serializable;

public class Mail implements Serializable{
	
	User sender;
	User reciver;
	String mail;
	
	
	public Mail(User sender, User reciver, String mail) {
		
		this.sender = sender;
		this.reciver = reciver;
		this.mail = mail;
	}


	public User getSender() {
		return sender;
	}


	public User getReciver() {
		return reciver;
	}


	public String getMailText() {
		return mail;
	}
	
	
	
	
	
	
	

}
