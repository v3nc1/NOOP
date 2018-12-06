
public class SUVCarUK extends Car {

	public SUVCarUK(String type) {
		
		super(type);
		
	}

	@Override
	public void manufacture() {
		// TODO Auto-generated method stub
		super.manufacture();
		System.out.println("Specialized manufacturing processes for UK SUV!!!");
	}
	
	public String toString() {
		
		return "Order details: a UK SUV was ordered";
	}
	
	

}
