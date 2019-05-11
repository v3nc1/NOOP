package Primjeri;

import Primjeri.Customer.TaxFunction;

public class TestTaxLambda {

	public static void main(String[] args) {
		
		
		//Dafinira jednu funkciju kao lambda izraz i sprema je u varijablu
		
		TaxFunction taxF=(double grossIncome)->{
			
			double fedTax=0;
			
			if (grossIncome<30000) {
				fedTax=grossIncome*0.05;
			}else {
				fedTax=grossIncome*0.06;
			}
			return fedTax;
		};
		
		//Definira drugu funkciju kao lambda izraz za obraèun 
		//poreza èlanovima mafije
		
		TaxFunction taxFMafija=(double grossIncome)->{
			double stateTax=0;
			
			if (grossIncome<30000) {
				
				stateTax=grossIncome*0.01;
			}else {
				stateTax=grossIncome*0.02;
			}
			return stateTax;
		};
		
		Customer c1=new Customer();
		c1.name="Mujo Paleka";
		c1.grossIncome=50000;
		c1.applyTaxCalcFunction(taxF);
		
		Customer c2=new Customer();
		c2.name="Dario Barièeviæ";
		c2.grossIncome=25000;
		c2.applyTaxCalcFunction(taxFMafija);
	}

}
