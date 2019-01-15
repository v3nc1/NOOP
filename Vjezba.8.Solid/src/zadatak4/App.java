package zadatak4;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<iRecept> kitchen=new ArrayList<>();
		
		kitchen.add(new Chinese());
		kitchen.add(new Mediterranian());
		kitchen.add(new Mexican());
		kitchen.add(new Indian());
		
		for(iRecept r:kitchen) {
			
			System.out.println(r.getClass().getSimpleName());
			r.provideAdditionalInfo();
			r.recommendWebSources();
			System.out.println("_____________________");
		}

	}

}
