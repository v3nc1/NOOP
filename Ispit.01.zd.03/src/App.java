import java.util.ArrayList;
import java.util.Random;

public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {


		ArrayList<Helicopter> helicopterList=new ArrayList<>();
		ArrayList<Aeroplane> aerplaneList=new ArrayList<>();
		
		
		
		
		for (int i=1;i<6;i++) {
			
			System.out.println("Loop: "+i);
			
			if (i%2==0) {
				
				
				Helicopter heli=new Helicopter("Bravo_"+i, i);
				System.out.println("Heli: "+Helicopter.getCnt());
				heli.fly(250, "South",genRndFloat(1, 250));
				helicopterList.add(heli);
				
			}else {
				
				Aeroplane aPlane=new Aeroplane("Falcon_"+i,i);
				System.out.println("Aero: "+Aeroplane.getCnt());
				aerplaneList.add(aPlane);
				
				aPlane.fly(1000, "North",genRndFloat(1, 1000));
			}
		}
		System.out.println("Helicopter distance: ");
		System.out.println(Helicopter.getDistance());
		System.out.println("--------------------------------");
		System.out.println("Aeroplane distance: ");
		System.out.println(Aeroplane.getDistance());
		
		
		

	}
	
	public static float genRndFloat(int max,int min) {
		
		Random rnd=new Random();
		
		float res=rnd.nextFloat()*(max-min)+min;
		
		
		return res;
	}

}
