import javax.swing.DefaultBoundedRangeModel;

public class Dog {
	
	float years;
	String name;
	String breed;
	
	
	public Dog(String name, float years) {
		
		this.years = years;
		this.name = name;
		
		System.out.println("\nName: "+name+"\n Years:"+years);
		
	}
	
	public void Bark() {
		
	}
	
	public void training(int year) {
		
		if(year==0) {
			System.out.println("For zero is stay on the spot.");
		}else if(year==1) {
			System.out.println("For one is walk forward.");
		}else if(year==2){
			System.out.println("For two is walk backward.");
		}else if(year==3) {
			System.out.println("For tree is run.");
		}else if(year==4) {
			System.out.println("For four is jump.");
		}else if(year==5) {
			System.out.println("For five is sit.");
		}else {
			System.out.println("Unknown command...");
		}
		
	}
	
	public String getBreed() {
		
		return null;
	}
	
	
	
	

}
