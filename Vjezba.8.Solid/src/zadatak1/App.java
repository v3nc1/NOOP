package zadatak1;

public class App {

	public static void main(String[] args) {
		
		User usr=new User("Antonio", "ONLY CASH");
		
		Apartment apt1 =new Apartment("Mostara", "B");
		
		usr.reserveAccomodation(apt1);
		
	}

}
