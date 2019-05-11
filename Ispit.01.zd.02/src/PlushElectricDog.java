
public class PlushElectricDog extends ToyDog {

	public PlushElectricDog(String name, float years) {
		super(name, years);
		// TODO Auto-generated constructor stub
	}
	
	public void Bark() {

		System.out.println(getClass()+" is barking loud...");

	}
	
	public void training(int year) {
		
		System.out.println("You can't train a toy!");
		
	}
	
	public void charge() {
		
		System.out.println("Put my batteries into a special charger...");
	}
}
