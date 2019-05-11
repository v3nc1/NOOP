import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProcessList {

	public ProcessList() {
		
		
	}
	
	public static void processingList(ArrayList<String> lista) {
		
		for(String s:lista) {
			
			System.out.println(s);
			System.out.println(s.length());
		}
	}
	
	public static void sortListDesc(ArrayList<String> lista) {
		
		
		
		lista.sort(new Comparator<String>() {
			
			@Override
			public int compare(String a, String b) {
				if (a.length()<b.length()) {
					return -1;
				}else {
					
					return 0;
				}
			}
		});
				
		
		System.out.println(lista.toString());		
		
	}
}
