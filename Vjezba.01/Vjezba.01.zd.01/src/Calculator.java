
public abstract class Calculator {
	
	public CalculationStrategy cls;
	public Calculator() {
		
		
		
	}
	
	public void display(float result) {
		
		System.out.println("Rezultat : "+ result);
	}
	
	public abstract float performCalculation(float a,float b);
		
		
	public void setStrategy(CalculationStrategy calStr) {
		
		cls=calStr;
	}

}
