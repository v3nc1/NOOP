
public class Obs implements ObserverWth {
	
	
	private String name;
	private float temp;
	private float hum;
	private float press;
	private ObserverGUI gui;
	
	public Obs(String name) {
		
		this.name=name;
		
	}
	
	public void setGui(ObserverGUI gui) {
		
		this.gui=gui;
	}
	
	
	@Override
	public void update(float temp, float hum, float press) {
		
		this.temp=temp;
		this.hum=hum;
		this.press=press;
		gui.update(temp, hum, press);

	}

	public String getTemp() {
		return temp+" °C";
	}

	public String getHum() {
		return hum+" %";
	}

	public String getPress() {
		return press+" hPa";
	}


	@Override
	public String toString() {
		
		return name;
	}
	
	

}
