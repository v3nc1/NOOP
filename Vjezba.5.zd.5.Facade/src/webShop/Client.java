package webShop;

public class Client {

	public static void main(String[] args) {
		
		OrderFacade ord=new OrderFacade(new UserAccount("Antonio", "JaoO"), new PaymentOption(), new ShipingType(), new WarehouseType());
		
		
		ord.logIn("Antonio", "JaoO");
		ord.payment();
		ord.confirmation();
		ord.delivery();

	}

}
