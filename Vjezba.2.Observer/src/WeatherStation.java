import java.util.ArrayList;

public class WeatherStation implements ObservableInt {
	
	private ArrayList<Observer> observers;
	private float temp;
	private float hum;
	private float press;
	
	
	
	public WeatherStation() {
		
		observers=new ArrayList<>();
		
		
	}
	

	@Override
	public void add(Observer obs) {
		
		observers.add(obs);

	}

	@Override
	public void remove(Observer obs) {
		
		observers.remove(obs);
		

	}

	@Override
	public void notifyObs() {
		
		for (Observer ob: observers) {
			
			ob.update(temp,hum,press);
			
		}

	}
	
	public void setNewData(float temp,float hum,float press) {
		
		this.temp=temp;
		this.hum=hum;
		this.press=press;
		
		stateHasChanged();
		
		
	}
	
	public void stateHasChanged() {
		
		notifyObs();
	}


	public float getTemp() {
		return temp;
	}


	public float getHum() {
		return hum;
	}


	public float getPress() {
		return press;
	}
	
	
	public void setState() {
		
		
		
	}

}
