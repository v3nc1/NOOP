
public class SportingDog extends Dog {

	public SportingDog(String name, float years) {
		super(name, years);
		
	}
	
	public void eat() {
		
		System.out.println("I can eat special food and meet...");
		
	}
	
	public void Bark() {
		
		System.out.println(getClass()+" is barking loud...");

	}
}
