import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Server implements Maintance {
	
	public SimpleDateFormat sDat=new SimpleDateFormat("dd-MM-yyy");
	
	private ArrayList<Date> ard= new ArrayList<>();;
	private ArrayList<Integer> out=new ArrayList<>();
	private String serName;
	
	
	public Server(String serName) {
		
		this.serName = serName;
		
	}
	
	public void start(){
		
	}
	
	public void stop() {
		
	}
	
	public void charge() {
		
	}
	
	public void operate() {
		
	}
	
	public static String getUrlSource(String info) {
		
		return info;
	}
	
	public String getSerName() {
		return serName;
	}

	public void setSerName(String serName) {
		this.serName = serName;
	}

	
	
	public ArrayList<Integer> getOut(){
	
		return out;
	}
	
	public String toString() {
		
		return serName;
	}
	
	
	

	@Override
	public ArrayList<Date> scheduledMaintance() {

		return ard;
	}

	@Override
	public ArrayList<Integer> outOfUsage() {
		
		
		int dana=ThreadLocalRandom.current().nextInt(1, 50);
		
		out.add(dana);
		
		return out;
	}

	public void setArd(Date sDat) {
		
		
		ard.add(sDat);
	}

}
