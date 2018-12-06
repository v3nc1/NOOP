package webShop;

public class OrderFacade {
	
	protected CustomerAccount usrAcc;
	
	protected Payment payment;
	
	protected Shipping shiping;
	
	protected Warehouse warehouse;
	
	
	
	
	
	
	public OrderFacade(CustomerAccount usrAcc, Payment payment, Shipping shiping, Warehouse warehouse) {
		
		
		this.usrAcc = usrAcc;
		this.payment = payment;
		this.shiping = shiping;
		this.warehouse = warehouse;
	}

	public void logIn(String usName,String pass) {
		
		usrAcc.assign2Account(usName, pass);
		usrAcc.checkCustomerData();
		
	}
	
	public void payment() {
		
		payment.assign2PaymentAccounts(usrAcc.getUser(), usrAcc.getPass());
		payment.checkCustomerData();
		payment.link2CustomerBankAccount();
		payment.performTransaction2BankAccount();
		
		
	}
	
	public void delivery() {
		
		shiping.airTransportation();
		shiping.deliveryNotification();
		
		
	}
	
	public void confirmation() {
		
		warehouse.invoiceProcessing();
		warehouse.findCustomerItem();
		warehouse.packingItems();
		warehouse.dispatchment();
		
		
	}

}
