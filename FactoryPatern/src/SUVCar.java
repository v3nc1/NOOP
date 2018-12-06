
public class SUVCar extends Car {

	public SUVCar(String type) {
		
		super(type);
		
	}

	@Override
	public void manufacture() {
		// TODO Auto-generated method stub
		super.manufacture();
		System.out.println("Specialized manufacturing processes for EU SUV!!!");
	}
	
	public String toString() {
		
		return "Order details: a EU SUV was ordered";
	}
	
	

}
