import java.util.ArrayList;

public class WeatherStation implements ObservedInt {
	
	private ArrayList<ObserverWth> obs;
	private float temp;
	private float hum;
	private float press;
	
	
	public WeatherStation() {
		
		obs=new ArrayList<>();
	}
	
	public ArrayList<ObserverWth> getList(){
		
		return obs;
	}

	@Override
	public void add(ObserverWth ob) {
		
		obs.add(ob);

	}

	@Override
	public void remove(ObserverWth ob) {
		
		obs.remove(ob);

	}



	@Override
	public void notifyObs(float temp, float hum, float press) {
		
		this.temp=temp;
		this.hum=hum;
		this.press=press;
		
		sendData();
		
	}
	
	private void sendData() {
		
		
		for (ObserverWth ob:obs) {
			
			ob.update(temp, hum, press);
		}
	}

}
