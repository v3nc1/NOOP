
public class HatchbackCarUK extends Car {

	public HatchbackCarUK(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void manufacture() {
		// TODO Auto-generated method stub
		super.manufacture();
		System.out.println("Specialized manufacturing processes for UK Hatchback!!!");
	}
	
	
	public String toString() {

		return "Order details: a UK Hatchback was ordered";
	}

}
