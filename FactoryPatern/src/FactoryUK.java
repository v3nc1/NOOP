
public class FactoryUK extends CarStore {
	
	Car car;
	
	

	public FactoryUK() {
		super();
		
	}



	@Override
	protected Car createCar(String type, String color) {
		
		
		if (type.equals("SUV")) {
			car = new SUVCarUK("SUV UK");
		} else if (type.equals("Sedan")) {
			car = new SedanCarUK("Sedan UK");
		} else if (type.equals("Cabriolet")) {
			car = new CabrioletCarUK("Cabriolet UK");
		} else if (type.equals("Hatchback")) {
			car = new HatchbackCarUK("Hatchback UK");
		} else {

			System.out.println("Not possible to manufacture!!!");
			car = null;
		}

		return car;
	}

}
