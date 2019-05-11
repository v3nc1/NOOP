package StreamsGUI;

public class Tax {
	
	protected double grossIncom;
	private String state;
	private int dependents;
	private static int custCounter;
	
	
	protected double calcTax() {
		
		double cTax;
		
		if (grossIncom<30000) {
			
			cTax = grossIncom *0.05;
		}
		else {
			cTax = grossIncom * 0.06;
		}
		
		return cTax;
		//return (grossIncom*0.33 - dependents*100);
	}
	

	public Tax(double grossIncom, String state, int dependents) {
		
	
		this.grossIncom = grossIncom;
		this.state = state;
		this.dependents = dependents;
		
		custCounter++;
		
		System.out.println("Preparing the tax data for customer # "+ custCounter);
		System.out.println("Calculating tax for the state of "+ state);
	}
	
	
	
	public static String convertToEuros(double taxInDolars) {
		
		return "Tax in Euros: "+ taxInDolars/1.25;
		
		
	}


	public double getGrossIncom() {
		return grossIncom;
	}


	public void setGrossIncom(double grossIncom) {
		this.grossIncom = grossIncom;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getDependents() {
		return dependents;
	}


	public void setDependents(int dependents) {
		this.dependents = dependents;
	}


	public static int getCustCounter() {
		return custCounter;
	}


	public static void setCustCounter(int custCounter) {
		Tax.custCounter = custCounter;
	}
	
	
	
	

}
