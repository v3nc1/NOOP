
public class Helicopter implements Fly {
	
	private static float hellDistance;
	private static int cnt;
	
	private static float distance;
	private String name;
	private int id;
	

	public Helicopter(String name, int id) {
		cnt++;
		this.name=name;
		this.id=id;
		
	}

	@Override
	public void takeOff() {
		// TODO Auto-generated method stub

	}

	@Override
	public void land() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fly(float speed, String in, float distance) {
		
		
		System.out.println("Helicopter: "+ name +" id: "+id);
		System.out.println("Flying in: "+ in);
		System.out.println("Flying speed: "+ speed);
		System.out.println("-------------------------------------");
		
		hellDistance+=distance;
		

	}
	
	public static float getDistance() {
		
		return hellDistance;
		
	}
	
	public static int getCnt() {
		
		return cnt;
	}
	
	
}
