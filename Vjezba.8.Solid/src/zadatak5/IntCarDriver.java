package zadatak5;

public class IntCarDriver implements IPilot {

	@Override
	public void start() {

		startCar();

	}

	@Override
	public void navigate() {

		driveCar();
		changeSpeed();

	}

	@Override
	public String pilotVer() {

		return "Car Pilot";

	}

	@Override
	public void end() {
		stopCar();
	}

	public void startCar() {

		System.out.println("Starting car...");
	}

	public void stopCar() {

		System.out.println("Car shut down.");
	}

	public void driveCar() {

		System.out.println("Driving car...");
	}

	public void changeSpeed() {

		System.out.println("Changing speed's...");
	}

}
