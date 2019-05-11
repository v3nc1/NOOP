import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {
	
	
	private static  Map<Integer,ArrayList<?>> omp;
	private static int cntr;
	
	public Order() {
		
		
	}
	
	public static void createOrder(Customer cust,ArrayList<?> lista) {
		
		Map<Customer,Object> order=new HashMap<>();
		Order.omp = new HashMap<>();
		
		
		
		order.put(cust, lista);
		
		omp.put(cntr+1, lista);
		
		cntr++;
		
	}
	

	public static Map<Integer, ArrayList<?>> getOmp() {
		
		
		
		
		
		return omp;
	}
	
	public static ArrayList<Customer> getArrCust() {
		
		ArrayList<Customer> lista=new ArrayList<>();
		
		Customers custs=new Customers();
		
		for(Customer n:custs.getHmc().values()) {
			
			lista.add(n);
			
		}
		
		return lista;
	}
	
	public static void calcOrderPrice(ArrayList<?> lista) {
		
		int br=0;
		
		for(Object n:lista) {
			
			br++;
			
		}
		
		System.out.println("Order price: "+ (br*Goggles.getPrice()));
		
		
	}

}
