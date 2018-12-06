
public class SedanCarUK extends Car {

	public SedanCarUK(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void manufacture() {
		// TODO Auto-generated method stub
		super.manufacture();
		System.out.println("Specialized manufacturing processes for UK Sedan!!!");
	}
	
	public String toString() {

		return "Order details: a UK Sedan was ordered";
	}

}
