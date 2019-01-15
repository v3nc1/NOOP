package zadatak5;

public class IntShipPilot implements IPilot {

	@Override
	public void start() {
		startEngines();

	}

	@Override
	public void navigate() {

		sailOutHarbor();
		navigateBoat();
		sailIntoHarbor();

	}

	@Override
	public void end() {

		stopEngines();
	}

	@Override
	public String pilotVer() {

		return "Ship Pilot";

	}

	public void navigateBoat() {

		System.out.println("Boat in navigation...");
	}

	public void sailIntoHarbor() {

		System.out.println("Navigating into Harbor...");
	}

	public void sailOutHarbor() {

		System.out.println("Navigating out of Harbor...");
	}

	public void startEngines() {

		System.out.println("Starting engines...");
	}

	public void stopEngines() {

		System.out.println("Engines shut down.");
	}

}
