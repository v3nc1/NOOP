import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}
		public static ArrayList<String> gradovi=new ArrayList<>();

	public static void main(String[] args) {

			String input;
			
			Scanner sc=new Scanner(System.in);
			
			
			for(int i=0;i<3;i++) {
				try {
				
					System.out.println("Unesi grad: ");
					input=sc.next();
					
					if(input.matches("[a-zA-Z]+")==false) {
						
						throw new IOException();
					}else {
						
						popList(input);
						
						
					}
				}catch(IOException e) {
					i--;
					System.out.println("Enter proper name for city...");
					
				}
					
				}
			
			ProcessList.processingList(gradovi);
			
			ProcessList.sortListDesc(gradovi);
			/*for(String s:gradovi) {
				
				System.out.println(s);
			}*/
				
				
			
	}
			public static void popList(String st) {
				
				gradovi.add(st);
			}
			


}
