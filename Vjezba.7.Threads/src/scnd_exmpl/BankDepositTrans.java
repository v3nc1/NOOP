package scnd_exmpl;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class BankDepositTrans implements Runnable {
	
	BankAccount bnkAcc;
	
	
	

	public BankDepositTrans(BankAccount bnkAcc) {
		
		this.bnkAcc = bnkAcc;
		
	}


	@Override
	public void run() {

		System.out.println("POZVAN");
		

			makeDeposit();
		

	}
	
	
	private synchronized void makeDeposit() {

		while(bnkAcc.getTrans_counter()<10) {
			
			
		}
		


		int deposit = ThreadLocalRandom.current().nextInt(500, 5000);
		while(bnkAcc.getTrans_counter()<10) {
			
		}
			
		bnkAcc.updateFromBalance(deposit);

		System.out.println(">>>>>>>>>Deposit " + deposit + " to account made...");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
	}


	

}
