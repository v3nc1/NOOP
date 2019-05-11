import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {
	
	private Scanner sc;
	private int velicina;
	private boolean flag;
	private int[] lista;
	
	
	
	public Generator() {
		
		
		flag=false;
		Set<Integer> tempSet=new HashSet<>();

		
		while(flag!=true) {
			try {
				sc=new Scanner(System.in);
				System.out.println("Unesite broj elemenata liste -> 7 do max 20 elemenata");
				System.out.println("-----------------------------------------------------");
				velicina=sc.nextInt();
			}catch(InputMismatchException e) {

				System.out.println("Niste unjeli cijelobrojnu vrijednost u rasponu od 7 do 20");
				continue;
			}
			if(velicina>6&&velicina<21) {
				flag=true;
				this.lista=new int[velicina];
			}else {
				System.out.println("Trebate unjeti broj od7 do 20!");
			}
		}
		
		while(tempSet.size()!=velicina) {
			
			tempSet.add(ThreadLocalRandom.current().nextInt(1,101));
			
			
		}
		int br=0;
		for(Integer i:tempSet) {
			
			this.lista[br]=i;
			br++;
		}

	}
		public void ispisListe() {
			
			System.out.println("Orginalna lista - nesortirana:");
			System.out.println(Arrays.toString(lista));
			
		}
		public int[] getLista() {
			return lista;
		}
		
	
	

}
