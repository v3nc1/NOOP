import java.util.HashMap;
import java.util.Map;

public class App {
	
	public static Map<Integer,Customer> mapa=new HashMap<>();

	public static void main(String[] args) {
		
		
		
		
		Customers kl=new Customers();
		Customer cus;
		
		
		
		
		createCustomer(1, "Ante", "Bojna 2", "ante@net.hr", kl);
		createCustomer(2, "Vinko", "Rujno 2", "vingo@net.hr", kl);
		createCustomer(3, "Marko", "Maka 12", "marko@net.hr", kl);
		
		Goggles.setPrice(10);
		
		
		Println3D.printGooggles(5,kl.getHmc().get(1));
		Println3D.printGooggles(10,kl.getHmc().get(1));
		Println3D.printGooggles(8,kl.getHmc().get(3));
		
		System.out.println("Ukupan broj naruðbi: "+Order.getOmp().keySet().hashCode());
		
		
		
		
		
		

			
		

		
		
		
	}
	public App() {
	}
	
	public static void createCustomer(int id,String name, String address,String mail,Customers cust) {
		
		
		
		Customer c1=new Customer(id,name,address,mail);
		
		mapa.put(id, c1);
		
		cust.addCustomer(mapa,c1);
		
		
		
		
		
		
		
	}

}
