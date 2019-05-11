import java.util.Arrays;

public class Answer {
	
	
	
	
	
	public Answer() {
		
		
	}
	
	public int[] sortAscList(int[] lista) {
		
		int temp=0;
		
		for(int i=1; i<lista.length;i++) {
			
			while(lista[i]<lista[i-1]) {
				
				temp=lista[i];
				lista[i]=lista[i-1];
				lista[i-1]=temp;
				sortAscList(lista);
				
			}
		}
		
		
		return lista;
	}
	
	public int[] sortDescList(int[] lista) {
		
		int temp=0;

		for(int i=1; i<lista.length;i++) {

			while(lista[i]>lista[i-1]) {

				temp=lista[i];
				lista[i]=lista[i-1];
				lista[i-1]=temp;
				sortDescList(lista);

			}
		}


		return lista;
		
	}
	
	public float calcAvgList(int[] lista) {
		
		float temp=0;
		
		for(int i:lista) {
			
			temp+=i;
		}
		
		return temp/lista.length;
		
	}
	
	

}
