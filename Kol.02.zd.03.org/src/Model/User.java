package Model;

import java.io.Serializable;

public class User implements Serializable{
	
	
	private String name;
	private int id;
	private int br;
	
	public User(String name,int id,int br) {
		
		this.name=name;
		this.id=id;
		this.br=br;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
	public int getNO() {
		
		return br;
	}
	

}
