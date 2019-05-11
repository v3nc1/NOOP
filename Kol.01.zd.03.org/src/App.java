import java.util.Arrays;
import java.util.Date;

public class App {

	private static String[] wth= {Weather.setWeather(),Weather.setWeather(),Weather.setWeather(),Weather.setWeather(),Weather.setWeather()};
	;

	public static void main(String[] args) {
		
		//Informations.start();
		
		Team t1=new Team("Prvi team", 1);
		Team t2=new Team("Drugi team", 2);
		
		Team[] niz= {t1,t2,t2,t1,t1};
		
		for (int i=0;i<niz.length;i++) {
			
			Reservations.conditReservations(wth[i], niz[i]);
			
		}
		System.out.println(Arrays.toString(wth));
		Reservations.listaAllReservations();
		
		Reservations.listReserCourts();
		
		//Informations.stop();
		
		
	}
	
	public App() {
		
		
	}

}
