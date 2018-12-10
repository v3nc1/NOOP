package first_exmpl;

import java.util.concurrent.ThreadLocalRandom;

public class Robot {
	
	private String name;
	private int id;
	
	public Robot(String name) {
		
		this.name=name;
		
		id=ThreadLocalRandom.current().nextInt(0,101);
		
		
	}
	
	public void description() {
		
		System.out.println("+++++++++++++++++++++++");
		System.out.println("Robot: "+name);
		System.out.println("ID: "+id);
	}

}
