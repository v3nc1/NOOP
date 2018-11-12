
public abstract class Car {
	
	protected String type;

	public Car(String type) {
		
		this.type = type;
	}
	
	public void manufacture() {
		
		System.out.println("=========== New car order ================");
		System.out.println("Basic manufacturing process...");
		
	}
	
	public void paint(String color) {
		
		System.out.println("Painting car in : " + color);
	}
	
	public void deliver() {
		
		System.out.println("Deliver car to the car store...");
	}
	
	
	

}
