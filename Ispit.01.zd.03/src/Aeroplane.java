
public class Aeroplane implements Fly {
	
	public static float aeroDistance;
	private static int cnt;
	
	private String name;
	private int id;
	private float speed;
	private String in;
	private float distance;

	public Aeroplane(String name, int id) {
		
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
		
		
		System.out.println("Aeroplane: "+ name +" id: "+id);
		System.out.println("Flying in: "+ in);
		System.out.println("Flying speed: "+ speed);
		System.out.println("-------------------------------------");
		aeroDistance+=distance;
		
	}
	
	public static float getDistance() {
		
		return aeroDistance;

	}
	
	public static int getCnt() {
		
		return cnt;
	}
	


}
