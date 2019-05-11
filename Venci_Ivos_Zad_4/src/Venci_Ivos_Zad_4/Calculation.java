package Venci_Ivos_Zad_4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Calculation {
	
	private static Map<String, ArrayList<Integer>> cijene=new LinkedHashMap<>();
	private static Map<String, ArrayList<Integer>> auta=new LinkedHashMap<>();
	
	

	public Calculation() {
	
		
	}
	
	public void ulazneListe(String[][] servis,String[][] auto) {
		
		for(int i=1;i<servis.length;i++) {
			
			ArrayList<Integer> cijeneLista=new ArrayList<>();
			for (int j =1; j<servis.length;j++) {
				
				
				cijeneLista.add(Integer.parseInt(servis[i][j]));
				
			}
			
			cijene.put(servis[i][0], cijeneLista);
			
			
		}

		for(int i=1;i<auto.length;i++) {

			ArrayList<Integer> servisLista=new ArrayList<>();
			for (int j =1; j<auto.length;j++) {


				servisLista.add(Integer.parseInt(auto[j][i]));

			}

			auta.put(servis[0][i], servisLista);


		}
		/*
		for(String s:cijene.keySet()) {
			
			System.out.println(s+cijene.get(s));
		}
		
		for(String s:auta.keySet()) {

			System.out.println(s+auta.get(s));
		}
		*/
		
	}
	
	public void calculate() {
		
		int cijena;
		int br=0;
		
		String servis=null;
		
			
			for(String c:cijene.keySet()) {
				cijena=0;
				
				for(String a:auta.keySet()) {
					
					
				cijena+=auta.get(a).get(br);
				
				
			}
			
			System.out.println("Zbroj automobila na servisu "+ c +" -->"+ cijena);
			
			
			br++;
		}
			
			br=0;
			int br2=0;
			
			for(String c:cijene.keySet()) {
				cijena=0;
				br2=0;
				for(String a:auta.keySet()) {
					
					
					
				cijena+=auta.get(a).get(br)*cijene.get(c).get(br2);
				
				br2++;
			}
			
			System.out.println("Zarada na servisu "+ c +" -->"+ cijena);
			br++;
			
			
		}
		
		
		
	}

}
