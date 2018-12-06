
public class Client {

	public static void main(String[] args) {
		
		
		Auto car=new GlassMode(new Suspension(
				new EnginePower(
						new CarModell("Toyota Yaris"))));
		
		System.out.println(car.changeCarPref());
		
		
	}

}
