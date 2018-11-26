
public class Suspension implements Auto {

	Auto auto;

	public Suspension(Auto auto) {

		this.auto = auto;

	}

	@Override
	public String changeCarPref() {

		String car = auto.changeCarPref() + "\n-Suspension upgraded with 22' weels and gas suspension";

		return car;

	}

}
