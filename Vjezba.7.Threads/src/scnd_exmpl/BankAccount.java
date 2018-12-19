package scnd_exmpl;

import javax.swing.plaf.synth.SynthSpinnerUI;

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

	public synchronized void withdrawFromBalance(double amnt) {
		balance = balance - amnt;
		trans_counter+=1;
		System.out.println(trans_counter +"  Transaction "+   " was made...");
		
		
	}
	
	public synchronized void updateFromBalance(double amnt) {
		balance = balance + amnt;
	}

	public synchronized int getTrans_counter() {
		return trans_counter;
	}
	
	
	
	
	

}
