
public class EnginePower extends CarUpgrade {

	

	public EnginePower(Auto auto) {

		super(auto);

	}

	@Override
	public String changeCarPref() {

		String car = auto.changeCarPref() + "\n-Engine upgraded to 500 Ks";

		return car;

	}

}
