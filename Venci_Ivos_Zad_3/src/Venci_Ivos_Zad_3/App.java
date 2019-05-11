package Venci_Ivos_Zad_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
	
	private static Scanner sc=new Scanner(System.in);
	
	
	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		ArrayList<Student> stList1=new ArrayList<>();
		ArrayList<Student> stList2=new ArrayList<>();
		ArrayList<University> unList= new ArrayList<>();
		Map<University, ArrayList<Student>> mapa=new HashMap<>();
		
		int stNo=4;
		int unNo=2;
		int br=0;
		
		
		stList1=genStudents(stNo);
		stList2=genStudents(stNo);
		
		unList=genUniversityList(unNo);

		
		for(University u:mapa.keySet()) {
			
			System.out.println("///////"+u.toString()+"///////");
			
				for(Student s:mapa.get(u)) {
					
					System.out.println(s.toString());
				}
			
		}
		System.out.println("\n");
		for(University u:unList) {
			
			System.out.println("////University////");
			System.out.println(u.toString());
			if(br==0) {
				mapa.put(u, stList1);
				br++;
			}else {
				mapa.put(u, stList2);
			}
		}
		System.out.println("\n");
		
		for(Student s:stList1) {

			System.out.println("////Student////");
			System.out.println(s.toString());
			

		}
		for(Student s:stList2) {

			System.out.println("////Student////");
			System.out.println(s.toString());
			

		}


	}
	
	public static ArrayList<University> genUniversityList(int nr){
		
		String name;
		ArrayList<University> unList= new ArrayList<>();
		
		for(int i=0;i<nr;i++) {
			
			
			System.out.println("Unesi naziv sveucilista...");
			name=sc.next();
			
			University un=new University(name);
			
			unList.add(un);
			
			
			
			
		}
		
		
		
		return unList;
	}
	
	public static ArrayList<Student> genStudents(int nr){
		
		String name;
		ArrayList<Student> stList=new ArrayList<>();
		

		for(int i=0;i<nr;i++) {


			System.out.println("Unesi ime studenta...");
			name=sc.next();

			Student st=new Student(name);

			stList.add(st);
			
			
		}
		
		
		
		
		
		return stList;
		
	}
	

	
	
	

}
