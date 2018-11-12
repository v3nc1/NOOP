
public class SimpleCarCreator {
	
	Car car;

	public Car createCar(String type, String color){

		if (type.equals("SUV")) {
			car = new SUVCar("SUV");
		} else if (type.equals("Sedan")) {
			car = new SedanCar("Sedan");
		} else if (type.equals("Cabriolet")) {
			car = new CabrioletCar("Cabriolet");
		} else if (type.equals("Hatchback")) {
			car = new HatchbackCar("Hatchback");
		} else {

			System.out.println("Not possible to manufacture!!!");
			car = null;
		}

		return car;

	}


}
