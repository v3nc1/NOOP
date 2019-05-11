import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Elevator implements Maintance {
	
	public int br;
	
	private int floor;
	private int elID;
	
	
	public Elevator(int floor) {
		
		this.elID = br++;
		this.floor = floor;
	}
	
	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getElID() {
		return elID;
	}

	public void setElID(int elID) {
		this.elID = elID;
	}

	public void start(){
		
	}
	
	public void stop() {
		
	}
	
	public void charge() {
		
	}
	
	public void operate() {
		
	}

	public int getCurrFloor() {
		return floor;
	}
	
	public void changeFloor(int fl) {
		
	}
	
	


	@Override
	public ArrayList<Date> scheduledMaintance() {
		
		ArrayList<Date> ard=new ArrayList<>();
		Date datum=new Date();
		
		
		
		ard.add(datum);
		
		return ard;
	}

	@Override
	public ArrayList<Integer> outOfUsage() {
		
		ArrayList<Integer> outOf=new ArrayList<>();
		int dana=ThreadLocalRandom.current().nextInt(1, 50);
		
		outOf.add(dana);
		
		return outOf;
	}

}
