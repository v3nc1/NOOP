
public class Suspension extends CarUpgrade {

	
	public Suspension(Auto auto) {

		super(auto);

	}

	@Override
	public String changeCarPref() {

		String car = auto.changeCarPref() + "\n-Suspension upgraded with 22' weels and gas suspension";

		return car;

	}

}
