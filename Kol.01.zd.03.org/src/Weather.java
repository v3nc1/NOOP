import java.util.concurrent.ThreadLocalRandom;

public class Weather {
	
	public static final String SUN="sunny";
	public static final String OVR="overcas";
	public static final String RIN="rainy";
	
	public Weather() {
		
	}
	
	public static String setWeather() {
		
		int gen=ThreadLocalRandom.current().nextInt(1,4);
		
		if(gen==1) {
			
			return SUN;
		}else if (gen==2) {
			
			return OVR;
		}else {
			
			return RIN;
		}
		
	}

}
