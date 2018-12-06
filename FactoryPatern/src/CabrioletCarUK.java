
public class CabrioletCarUK extends Car {

	public CabrioletCarUK(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void manufacture() {
		// TODO Auto-generated method stub
		super.manufacture();
		System.out.println("Specialized manufacturing processes for UK Cabrio!!!");
	}

	public String toString() {

		return "Order details: a UK Cabrio was ordered";
	}

}
