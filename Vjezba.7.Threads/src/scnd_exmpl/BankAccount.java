package scnd_exmpl;

public class BankAccount {
	
	private double balance;
	private int trans_counter;

	
	public BankAccount(double balance) {
		
		this.balance=balance;
		trans_counter=0;
		
	}

	public double getBalance() {
		
		
		return balance;
	}

	public void withdrawFromBalance(double amnt) {
		balance = balance - amnt;
		trans_counter+=1;
		System.out.println(trans_counter +" No. Transaction "+   " was made...");
		
		
	}
	
	public void updateFromBalance(double amnt) {
		balance = balance + amnt;
	}

	public int getTrans_counter() {
		return trans_counter;
	}
	
	
	
	
	

}
