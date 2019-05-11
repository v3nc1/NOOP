package GUI;

import java.util.EventObject;


public class MailEvent extends EventObject{
	
	private String sender;
	private String reciver;
	private String text;
	
	
	public MailEvent(Object ob) {
		
		super(ob);
		
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public void setReciver(String reciver) {
		this.reciver = reciver;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getSender() {
		return sender;
	}


	public String getReciver() {
		return reciver;
	}


	public String getText() {
		return text;
	}
	
	

}
