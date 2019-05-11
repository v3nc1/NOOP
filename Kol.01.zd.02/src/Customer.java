
public class Customer {
	
	private int id;
	private String name;
	private String address;
	private String mail;
	
	
	public Customer(int id,String name,String address,String mail) {
		
		this.id=id;
		this.name=name;
		this.address=address;
		this.mail=mail;
		
		
		
	}
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getAddress() {
		return address;
	}


	public String getMail() {
		return mail;
	}

}
