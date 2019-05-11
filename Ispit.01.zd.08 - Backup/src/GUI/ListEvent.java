package GUI;

import java.util.ArrayList;
import java.util.EventObject;

import Model.Mail;
import Model.User;

public class ListEvent extends EventObject{
	
	private String user;
	private String reciver;
	private ArrayList<String> sentMail;
	private ArrayList<String> recivedMail;
	

	public ListEvent(Object ob) {
		super(ob);
		
		sentMail=new ArrayList<>();
		recivedMail=new ArrayList<>();
		
	}


	public void setUser(String user) {
		this.user = user;
	}
	
	public void setReciver(String user) {
		this.reciver = user;
	}


	public void addSentMail(String st) {
		sentMail.add(st);
	}


	public void addRecivedMail(String st) {
		recivedMail.add(st);
	}


	public String getUser() {
		return user;
	}
	
	public String getReciver() {
		
		return reciver;
	}


	public ArrayList<String> getSentMail() {
		return sentMail;
	}


	public ArrayList<String> getRecivedMail() {
		return recivedMail;
	}



	
	
}
