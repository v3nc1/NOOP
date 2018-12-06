
public class MobObserver implements DisplayInt, Observer {

	WeatherStation wthStation;

	private float temp;
	private float hum;
	private float press;

	public MobObserver(WeatherStation wSt) {

		wthStation = wSt;

	}

	@Override
	public void display() {
		System.out.println("++++++++++++++++++++++");
		System.out.println("++++++MobilePhone+++++");
		System.out.println("Temp: " + temp + "°C");
		System.out.println("Humidity: " + hum + "%");
		System.out.println("Pressure: " + press + " hPs");

	}

	@Override
	public void update(float temp, float hum, float press) {

		this.temp = temp;
		this.hum = hum;
		this.press = press;

		display();

	}

}
