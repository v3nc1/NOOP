package scnd_exmpl;

import java.util.concurrent.ThreadLocalRandom;

public class App {

	public static void main(String[] args) {
	
		BankAccount bank=new BankAccount(ThreadLocalRandom.current().nextInt(1000,10000));
		BankWithdrawTrans transaction=new BankWithdrawTrans(bank);
		BankDepositTrans deposit=new BankDepositTrans(bank);
		
		
		Thread client1=new Thread(transaction);
		Thread client2=new Thread(transaction);
		Thread client3=new Thread(deposit);
		
		
		
		client1.setName("Husbant");
		client2.setName("Wife");
		client3.setName("Deposit");
		
		client1.start();
		
	
		client2.start();
		
		
		client3.start();
		
		
		
	}

}
