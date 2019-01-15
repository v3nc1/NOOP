package zadatak1;

public class User {
	
	private String name;
	private int id;
	private static int cnt;
	private Booking booking;
	private Payment payment;
	
	public User(String name,String payMeth) {
		
		booking=new Booking();
		payment=new Payment(payMeth);
		
		this.name=name;
		id=cnt;
		cnt++;
	}
	
	public void reserveAccomodation(Apartment apt) {
		
		booking.makeBooking(apt);
		payment.makePayment();
	}
	
	
	public void cancleBooking(Apartment apt) {
		
		booking.cancelBooking(apt);
	}
	
	public void makeCommentOnAccomodation(Apartment apt) {
		
	}
	
	public String getName() {
		
		return name;
	}
	

}
