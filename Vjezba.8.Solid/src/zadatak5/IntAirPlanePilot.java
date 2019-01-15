package zadatak5;

public class IntAirPlanePilot implements IPilot {

	@Override
	public void start() {
		startEngines();

	}

	@Override
	public void navigate() {
		takeOffPlane();
		flyThePlane();
		maneouverPlane();
		safelyLandingPlane();

	}

	@Override
	public void end() {
		
		stopEngines();

	}

	@Override
	public String pilotVer() {

		return "Airplane Pilot";

	}

	public void safelyLandingPlane() {

		System.out.println("Landing Plane...");
	}

	public void flyThePlane() {

		System.out.println("Flying Plane...");
	}

	public void maneouverPlane() {

		System.out.println("Maneouvering Plane...");
	}

	public void takeOffPlane() {

		System.out.println("Takeing off with Plane...");
	}

	public void startEngines() {

		System.out.println("Starting engines...");
	}

	public void stopEngines() {

		System.out.println("Engines shut down.");
	}

}
