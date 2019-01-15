package zadatak5;

import java.util.ArrayList;
import java.util.List;

public class AppClient {

	public static void main(String[] args) {
		
		List<IPilot> pilotList=new ArrayList<>();
		
		
		pilotList.add(new IntAirPlanePilot());
		pilotList.add(new IntCarDriver());
		pilotList.add(new IntShipPilot());
		pilotList.add(new IntHelicopterPilot());
		
		pilotList.forEach(pilot -> {
			
			System.out.println("\n>>>>>>>******<<<<<<<");
			System.out.println("Testing "+pilot.pilotVer());
			System.out.println("____________________");
			
			pilot.start();
			pilot.navigate();
			pilot.end();
			
		});
		

	}

}
