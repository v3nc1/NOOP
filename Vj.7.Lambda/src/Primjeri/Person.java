package Primjeri;

public class Person {
	
	private String name;
	private char wStat;  // 'E' or 'C'
	
	public Person(String name,char wStat) {
		
		this.name=name;
		this.wStat=wStat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getwStat() {
		return wStat;
	}

	public void setwStat(char wStat) {
		this.wStat = wStat;
	}
	
	public boolean validatePayIncrease(Payable increaseFunction, int percent) {
		
		boolean isIncreaseValid=increaseFunction.increasePay(percent);
		
		System.out.println("Increasing pay for "+name+" is "+(isIncreaseValid? "valid.":"not valid."));
		return isIncreaseValid;
	}
	
	
	@FunctionalInterface
	public interface Payable {
		
		public boolean increasePay (int percent);
		
		final int increase_cap=20;

	}

}
