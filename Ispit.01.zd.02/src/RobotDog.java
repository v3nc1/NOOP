
public class RobotDog extends ToyDog {

	public RobotDog(String name, float years) {
		super(name, years);
		// TODO Auto-generated constructor stub
	}
	
	public void Bark() {

		System.out.println(getClass()+" is barking loud...");

	}
	
	public void charge() {

		System.out.println("Connect a charger...");
	}
	
	public void intDivision(int a, int b) {
		
		if(a==0||b==0) {
			System.out.println("Division is not possible with 0!");
			
		}else {
			System.out.println("Result: "+(a/b));
		}
		
		
	}
	public void training(int year) {
		
	}
}
