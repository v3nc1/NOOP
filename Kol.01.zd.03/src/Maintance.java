import java.util.ArrayList;
import java.util.Date;

public interface Maintance {
	
	public ArrayList<Date> scheduledMaintance();
	
	public ArrayList<Integer> outOfUsage();
}
