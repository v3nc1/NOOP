
public class GlassMode implements Auto {

	Auto auto;

	public GlassMode(Auto auto) {

		this.auto = auto;

	}

	@Override
	public String changeCarPref() {
		String car = auto.changeCarPref() + "\n-Tinted glass installed";

		return car;

	}

}
