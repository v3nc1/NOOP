package gui;
import java.util.EventObject;

public class LeftFormEvent extends EventObject {
	
	private String name;
	private String city;
	private String mail;
	private int counter;
	
	

	public LeftFormEvent(Object source) {
		super(source);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	public int getNumClicked() {
		return counter;
	}
	public void setCounter(int cnt) {
		this.counter = cnt;
	}
	
	
	

}
