import java.nio.file.FileAlreadyExistsException;

public class App {

	public static void main(String[] args) {

		
		CarStore csEu = new FactoryEU();

		csEu.orderCar("Sedan", "Bilo");

		CarStore csUk = new FactoryUK();

		csUk.orderCar("SUV", "Crno");

	}

}
