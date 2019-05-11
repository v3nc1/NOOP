
import java.util.HashMap;
import java.util.Map;

public class Customers {
	
	public Map<Integer,Customer> mapa=new HashMap<>();
	
	
	
	
	public Customers() {
		
		
	}
	
	public void addCustomer(Map<Integer,Customer> custMapa,Customer cust) {
		
		 
		for(int var:custMapa.keySet()) {
			
			mapa.put(var, custMapa.get(var));
			
			
		}
		
	//	System.out.println(mapa.toString());
		
		
		
		
	}
	
	public Map<Integer,Customer> getHmc(){
		int i=1;
		/*for (int var:mapa.keySet()) {
		
			
			System.out.println(var+" Kupac "+mapa.get(var).getName());
		//popis.put(i,var.values());
		i++;
		}*/
		
		return mapa;
		
		
	}

}
