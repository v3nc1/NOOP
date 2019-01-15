package zadatak1;

public class Payment {
	
	String paymentMethode;
	
	public Payment(String payMth) {
		
		paymentMethode=payMth;
	}
	
	public void makePayment() {
		
		System.out.println("Making payment by "+ paymentMethode);
		
	}
	
	

}
