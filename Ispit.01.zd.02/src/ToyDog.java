
public class ToyDog extends Dog {

	public ToyDog(String name, float years) {
		super(name, years);
		// TODO Auto-generated constructor stub
	}
	
	public void Bark() {

		System.out.println(getClass()+" is barking loud...");

	}
	
	public void charge() {
		
		System.out.println("Charging...");
	}

}
