
public class HybrideMode implements Auto {

	Auto auto;

	public HybrideMode(Auto auto) {

		this.auto = auto;

	}

	@Override
	public String changeCarPref() {
		String car = auto.changeCarPref() + "\n-Upgrade with Hybrid technology";

		return car;

	}

}
