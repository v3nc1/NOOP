
public class SedanCar extends Car {

	public SedanCar(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void manufacture() {
		// TODO Auto-generated method stub
		super.manufacture();
		System.out.println("Specialized manufacturing processes for Sedan!!!");
	}
	
	public String toString() {

		return "Order details: a Sedan was ordered";
	}

}
