package webShop;

public class PaymentOption implements Payment {
	
	private static String user;
	private static String pass;
	
	
	

	@Override
	public void assign2PaymentAccounts(String usName, String pass) {
		
		user=usName;
		this.pass=pass;
		
		System.out.println("--------------------------");
		System.out.println("Account : xxxx-xxxx-xxxx-xxxx");
		System.out.println("Assigned to user "+ usName);

	}

	@Override
	public void checkCustomerData() {
		System.out.println("--------------------------");
		System.out.println("Customer data correct");

	}

	@Override
	public void link2CustomerBankAccount() {
		System.out.println("--------------------------");
		System.out.println("Bank account linked to customer "+user);

	}

	@Override
	public boolean performTransaction2BankAccount() {
		System.out.println("--------------------------");
		System.out.println("Transaction processed");
		return true;
	}

}
