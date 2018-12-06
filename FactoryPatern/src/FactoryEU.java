
public class FactoryEU extends CarStore {

	Car car;

	public FactoryEU() {
		super();

	}

	@Override
	protected Car createCar(String type, String color) {

		if (type.equals("SUV")) {
			car = new SUVCar("SUV EU");
		} else if (type.equals("Sedan")) {
			car = new SedanCar("Sedan EU");
		} else if (type.equals("Cabriolet")) {
			car = new CabrioletCar("Cabriolet EU");
		} else if (type.equals("Hatchback")) {
			car = new HatchbackCar("Hatchback EU");
		} else {

			System.out.println("Not possible to manufacture!!!");
			car = null;
		}

		return car;

	}

}
