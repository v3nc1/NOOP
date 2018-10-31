
public class AddStrategy implements CalculationStrategy {
	
	
	public AddStrategy() {
		
	}

	@Override
	public float calculation(float a, float b) {
		
		System.out.println(a+b);
		return a+b;
	}

}
