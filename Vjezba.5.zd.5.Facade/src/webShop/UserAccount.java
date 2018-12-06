package webShop;

public class UserAccount implements CustomerAccount {
	
	
	private String user;
	private String pass;
	
	

	public UserAccount(String user, String pass) {
		
		this.user = user;
		this.pass = pass;
	}

	@Override
	public void assign2Account(String usName, String pass) {
		
		System.out.println("--------------------------");
		System.out.println("User name: "+usName );
		System.out.println("Password: "+pass);
		System.out.println("Assigned to account !");
	}

	@Override
	public void checkCustomerData() {
		
		System.out.println("--------------------------");
		System.out.println("Customer data correct ");

	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}
	
	

}
