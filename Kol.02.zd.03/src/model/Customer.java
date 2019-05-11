package model;

import java.io.Serializable;

public class Customer implements Serializable{

	private static int cnt = 1;
	private String name;
	private String city;
	private String mail;
	private int id;
	
	
	public Customer(String name, String city, String mail) {
		
		this.name = name;
		this.city = city;
		this.mail = mail;
		this.id = cnt;
		cnt ++;
		
	}


	public String getName() {
		return name;
	}


	public String getCity() {
		return city;
	}


	public String getMail() {
		return mail;
	}
	
	public int getID() {
		
		return id;
	}
	
	
}
