package webShop;

public interface Payment {
	
	public void assign2PaymentAccounts(String usName, String pass);
	
	public void checkCustomerData();
	
	public void link2CustomerBankAccount();
	
	public boolean performTransaction2BankAccount();

}
