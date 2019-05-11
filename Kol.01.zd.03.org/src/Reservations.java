import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Reservations {
	
	private static int cnt;
	private static Map<Integer,String> rTrm=new HashMap<>() ;
	private static Map<LocalDate,String> reservedCrts = new HashMap<>();
	private static LocalDate date;
	
	
	public Reservations() {
		
	}
	
	public static void conditReservations(String wth, Team tm) {
		
		cnt++;
		//System.out.println(tm.getTeamName());
		rTrm.put(cnt, tm.getTeamName());
		
		if(wth==Weather.SUN) {
			
			reservedCrts.put(genDate(), Playfield.OP);
			
			
		}else{
			
			reservedCrts.put(genDate(), Playfield.CO);
			
		}
		
		
	}
	
	public static LocalDate genDate() {
		
		LocalDate startDate = LocalDate.of(1980, 1, 1); // start date
		long start = startDate.toEpochDay();
		LocalDate endDate = LocalDate.now();
		long end = endDate.toEpochDay();

		long randomEpochDay = ThreadLocalRandom.current().longs(start,end).findAny().getAsLong();
		date = LocalDate.ofEpochDay(randomEpochDay); // random date between start and end

		return date;
		
	}
	
	public static void listaAllReservations() {
		
		for(int key:rTrm.keySet()) {
			
			System.out.println("ID rezervacije: "+ key+" team: "+rTrm.get(key));
			
		}
		
		
	}
	
	public static void listReserCourts() {
		
		for(LocalDate date:reservedCrts.keySet()) {

			System.out.println("date: "+ date +" team: "+reservedCrts.get(date));

		}

	}
	
	public static boolean test(LocalDate date) {
		
		return false;
	}

}
