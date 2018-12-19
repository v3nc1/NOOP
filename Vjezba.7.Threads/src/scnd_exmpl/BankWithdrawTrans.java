package scnd_exmpl;

import java.util.concurrent.ThreadLocalRandom;

public class BankWithdrawTrans implements Runnable {

	BankAccount bnkAcc;
	
	public BankWithdrawTrans(BankAccount bnkAcc) {

		this.bnkAcc = bnkAcc;
		

	}

	@Override
	public void run() {
		for (int k = 1; k <= 20; k++) {
			
			int amount;
			System.out.println("\n");
			if (bnkAcc.getBalance() < 0) {
				System.out.println("Overdrawn!!!!");
			}

			amount = ThreadLocalRandom.current().nextInt(1, 200);
	
			makeWithdrawal(amount);

			
		}
	}

	private synchronized void makeWithdrawal(double amount) {
		System.out.println(Thread.currentThread().getName() + " wants to make " + amount + " withrawal");

		if (bnkAcc.getBalance() >= amount) {

			System.out.println(Thread.currentThread().getName() + " is ready to make withdrawel of " + amount + " €");

			System.out.println(Thread.currentThread().getName() + " --> woke up...");
			bnkAcc.withdrawFromBalance(amount);
			System.out.println(Thread.currentThread().getName() + " completes the withdrawal of " + amount + " €");
			accountState();
		} else if (bnkAcc.getBalance() < amount && bnkAcc.getBalance() != 0) {

			amount = bnkAcc.getBalance();

			System.out.println(Thread.currentThread().getName() + " is ready to make withdrawel of " + amount + " €");

			System.out.println(Thread.currentThread().getName() + " --> woke up...");
			bnkAcc.withdrawFromBalance(amount);
			System.out.println(Thread.currentThread().getName() + " completes the withdrawal of " + amount + " €");
			accountState();

		} else {

			System.out.println(
					"Sorry, not enough money for " + Thread.currentThread().getName() + " to make transaction.");
			accountState();
		}

	}

	private void accountState() {

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Current amount left: " + bnkAcc.getBalance());

	}

	

}
