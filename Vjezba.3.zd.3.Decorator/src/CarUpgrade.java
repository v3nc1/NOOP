
public abstract class CarUpgrade implements Auto {
	
	Auto auto;
	
	

	public CarUpgrade(Auto auto) {
		this.auto = auto;
	}



	@Override
	public abstract String changeCarPref();
	
	
}
