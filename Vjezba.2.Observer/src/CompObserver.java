import java.util.ArrayList;

public class CompObserver implements Observer, DisplayInt {

	WeatherStation wthStation;

	private ArrayList<Float> averageTemp;
	private ArrayList<Float> averageHum;
	private ArrayList<Float> averagePress;
	private float temp;
	private float hum;
	private float press;

	public CompObserver(WeatherStation wSt) {

		wthStation = wSt;
		averageTemp = new ArrayList<>();
		averageHum = new ArrayList<>();
		averagePress = new ArrayList<>();

	}

	@Override
	public void display() {

		System.out.println("++++++++++++++++++++++");
		System.out.println("++++++Computer++++++++");
		System.out.println("Temp: " + temp + "°C");
		System.out.println("Average Temp: " + average(averageTemp) + "°C");
		System.out.println("Humidity: " + hum + "%");
		System.out.println("Average Humidity: " + average(averageHum) + "%");
		System.out.println("Pressure: " + press + " hPs");
		System.out.println("Average Pressure: " + average(averagePress) + "%");

	}

	private float average(ArrayList<Float> lista) {

		float avg;
		float temp = 0;

		for (int i = 0; i < lista.size(); i++) {

			temp += lista.get(i);

		}

		avg = temp / lista.size();

		return avg;
	}

	@Override
	public void update(float temp, float hum, float press) {

		this.temp = temp;
		averageTemp.add(temp);
		this.hum = hum;
		averageHum.add(hum);
		this.press = press;
		averagePress.add(press);

		display();

	}

}
