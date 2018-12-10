package scnd_exmpl;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class BankDepositTrans implements Runnable {
	
	BankAccount bnkAcc;
	private int counter;
	
	

	public BankDepositTrans(BankAccount bnkAcc) {
		
		this.bnkAcc = bnkAcc;
		counter=0;
	}


	@Override
	public synchronized void run() {
		
		counter=bnkAcc.getTrans_counter();
		
		
		if (counter==10) {
			
			makeDeposit();
		}
		
		
		
		

	}
	
	
	private  void makeDeposit() {

		int deposit = ThreadLocalRandom.current().nextInt(500, 2000);
		bnkAcc.updateFromBalance(deposit);
		System.out.println("Deposit " + deposit + " to account made...");

	}


	

}
