import java.util.ArrayList;

public class Println3D {
	
	
	public Println3D() {
		
	}
		public static void printGooggles(int br,Customer cust){
			
			Order nar=new Order();
			
			ArrayList<Object> googles= new ArrayList<>();
			
			for(int i=0;i<br;i++) {
				
				googles.add(new Goggles());
				
				
				
				
			}
			
			
			nar.createOrder(cust,googles);
			System.out.println("Customer: "+cust.getName());
			System.out.println(googles);
			nar.calcOrderPrice(googles);
			
			System.out.println("\n");
		}
		


}


