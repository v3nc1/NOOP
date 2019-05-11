package Primjeri;

import java.util.ArrayList;
import java.util.List;

public class Winner {

	public static void main(String[] args) {
		
		List<String> winners = new ArrayList<>();
		
		winners.add("Mujo");
		winners.add("Jakov");
		winners.add("Miro");
		winners.add("Toni");
		
		//Imperativ stil
		System.out.println(">>>>Imperativ stil<<<<<");
		boolean gotMiro=false;
		
		for(String winner:winners) {
			
			if("Miro".equals(winner)) {
				
				gotMiro=true;
				System.out.println("Miro won? "+gotMiro);
				
				break;
			}
		}
		
		//Funkcionalni stil
		
		System.out.println(">>>>>Funkcionalni stil<<<<<<<<");
		
		System.out.println("Miro won? "+winners.contains("Miro"));

	}

}
