package Primjeri;

public class Customer {
	
	public String name;
	public double grossIncome;
	
	public void applyTaxCalcFunction(TaxFunction taxFunc) {
		
		double calculatedTax=taxFunc.calcTax(grossIncome);
		System.out.println("The calculated tax for "+name+" is "+calculatedTax);
		
	}
	@FunctionalInterface

	public interface TaxFunction{
		double calcTax(double grossIncome);
	}

}

