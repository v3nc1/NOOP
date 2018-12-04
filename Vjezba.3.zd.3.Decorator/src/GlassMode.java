
public class GlassMode extends CarUpgrade {

	

	public GlassMode(Auto auto) {

		super(auto);

	}

	@Override
	public String changeCarPref() {
		String car = auto.changeCarPref() + "\n-Tinted glass installed";

		return car;

	}

}
