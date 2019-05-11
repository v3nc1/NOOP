package GUI;

import java.util.ArrayList;
import java.util.EventObject;

public class ListEvent extends EventObject {
	
	private String user;
	private ArrayList<String> sentMail;
	private ArrayList<String> recivedMail;
	

	public ListEvent(Object ob) {
		super(ob);
		
		
	}


	public void setUser(String user) {
		this.user = user;
	}
	
	
	public String getUser() {
		return user;
	}
	

	public ArrayList<String> getSentMail() {
		return sentMail;
	}


	public ArrayList<String> getRecivedMail() {
		return recivedMail;
	}

	public void setSentMail(ArrayList<String> list) {
		
		sentMail=list;
	}
	
	public void setRecivedMail(ArrayList<String> list) {
		
		recivedMail=list;
	}

	

}
