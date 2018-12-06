
public class App {

	public static void main(String[] args) {
		
		WeatherStation wth=new WeatherStation();
		
		MobObserver mobObs=new MobObserver(wth);
		
		CompObserver compObs=new CompObserver(wth);
		
		
		wth.add(mobObs);
		wth.add(compObs);
		
		wth.setNewData(20, 50, 80);
		
		
		wth.setNewData(30, 60, 90);
		
		wth.setNewData(40, 70, 100);
		
		
	}

}
