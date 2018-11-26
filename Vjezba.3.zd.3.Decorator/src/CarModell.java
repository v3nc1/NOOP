
public class CarModell implements Auto {

	String name;

	public CarModell(String name) {

		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String changeCarPref() {
		String car = "Car model " + name;

		return car;
	}

}
