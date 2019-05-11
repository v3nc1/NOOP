package Venci_Ivos_Zad_3;

import java.util.concurrent.ThreadLocalRandom;

public class Student {

	private String name;
	private static int cnt;
	private int stuYear;
	private int id;
	
	
	public Student(String name) {
		
		cnt++;
		
		this.name = name;
		this.stuYear = genStudYear();
		this.id = cnt;
	}
	
	
	private int genStudYear() {
		
		
		return ThreadLocalRandom.current().nextInt(1,6);
	}


	public String getName() {
		return name;
	}


	public int getStuYear() {
		return stuYear;
	}


	public int getId() {
		return id;
	}
	
	public String toString() {
		
		
		return (name+" --> "+ "Year "+stuYear+" id: "+ id);
	}
	

}
