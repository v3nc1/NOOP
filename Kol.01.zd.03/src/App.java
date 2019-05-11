import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class App {

	public static void main(String[] args) {

		Elevator el1=new Elevator(1);
		Elevator el2=new Elevator(0);
		Elevator el3=new Elevator(3);
		
		Server ser1=new Server("Server01");
		Server ser2=new Server("Server02");
		Server ser3=new Server("Server03");
		
		
		SimpleDateFormat sDat=new SimpleDateFormat("dd-MM-yyy");
		
		
		el1.scheduledMaintance();
		el1.scheduledMaintance();
		el1.outOfUsage();
		el1.outOfUsage();
		
		el2.scheduledMaintance();
		el2.scheduledMaintance();
		el2.outOfUsage();
		el2.outOfUsage();
		
		el3.scheduledMaintance();
		el3.scheduledMaintance();
		el3.outOfUsage();
		el3.outOfUsage();
		
		try {
		ser1.setArd(sDat.parse("11-01-2011"));
		ser1.setArd(sDat.parse("11-02-2011"));
		ser1.setArd(sDat.parse("11-12-2011"));
		ser1.outOfUsage();
		ser1.outOfUsage();
		}catch(ParseException e) {
			System.out.println(e.toString());
		}
		
		
		/* for(Date d:el1.scheduledMaintance()) {
			
			System.out.println(sDat.format(d));
		};
		System.out.println(el1.outOfUsage());*/
		
		System.out.println("Server name: "+ser1.getSerName());
		
		for (Date d:ser1.scheduledMaintance()) {
			
			System.out.println(sDat.format(d));
		}
		
		System.out.println(ser1.outOfUsage());
		
		calcOut(ser1);

	}
	
	public static void calcOut(Maintance ob) {
		
		
		int br=0;
		
		for(Date n:ob.scheduledMaintance()) {
			
			br++;
			
		}
		
		for(int n:ob.outOfUsage()) {
			
			br+=n;
		}
		
		System.out.println("Out time for "+ob.toString()+"\n"+ br);
		
	}
	public App() {
		
	}

}
