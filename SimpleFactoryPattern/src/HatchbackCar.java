
public class HatchbackCar extends Car {

	public HatchbackCar(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void manufacture() {
		// TODO Auto-generated method stub
		super.manufacture();
		System.out.println("Specialized manufacturing processes for Hatchback!!!");
	}
	
	
	public String toString() {

		return "Order details: a Hatchback was ordered";
	}

}
