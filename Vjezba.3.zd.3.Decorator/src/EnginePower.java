
public class EnginePower implements Auto {

	Auto auto;

	public EnginePower(Auto auto) {

		this.auto = auto;

	}

	@Override
	public String changeCarPref() {

		String car = auto.changeCarPref() + "\n-Engine upgraded to 500 Ks";

		return car;

	}

}
