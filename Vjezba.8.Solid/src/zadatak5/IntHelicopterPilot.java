package zadatak5;

public class IntHelicopterPilot implements IPilot {

	@Override
	public void start() {

		startEngines();
		;

	}

	@Override
	public void navigate() {

		takeOffHelicopter();
		flyTheHelicopt();
		maneouverHelicopt();
		safelyLandingHelicopter();

	}

	@Override
	public void end() {

		stopEngines();

	}

	@Override
	public String pilotVer() {

		return "Helicopter Pilot";

	}

	public void safelyLandingHelicopter() {

		System.out.println("Landing Helicopter...");
	}

	public void flyTheHelicopt() {

		System.out.println("Flying Helicopter...");
	}

	public void maneouverHelicopt() {

		System.out.println("Maneouvering Helicopter...");
	}

	public void takeOffHelicopter() {

		System.out.println("Takeing off with Helicopter...");
	}

	public void startEngines() {

		System.out.println("Starting engines...");
	}

	public void stopEngines() {

		System.out.println("Engines shut down.");
	}

}
