import java.util.concurrent.ThreadLocalRandom;

public class Goggles {
	
	private int id;
	private static final String BEST="RayBan";
	private static int price;
	
	
	
	public Goggles(){
		
	
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id =ThreadLocalRandom.current().nextInt(1,15000);
	}
	public static int getPrice() {
		return price;
	}
	
	public static void setPrice(int value) {
		price = value;
	}
	
	public static String getBest() {
		return BEST;
	}
	
	
	

}
