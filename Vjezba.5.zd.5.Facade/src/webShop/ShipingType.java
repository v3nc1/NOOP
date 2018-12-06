package webShop;

import java.util.Random;

public class ShipingType implements Shipping {

	@Override
	public void roadTransportation() {

		System.out.println("--------------------------");
		System.out.println("Order shiped by Truck");

	}

	@Override
	public void seaTransportation() {

		System.out.println("--------------------------");
		System.out.println("Order shiped by Ship");

	}

	@Override
	public void airTransportation() {

		System.out.println("--------------------------");
		System.out.println("Order shiped by Airplane");

	}

	@Override
	public void deliveryNotification() {
		
		Random rnd=new Random();
		int n;
		do {
		n=rnd.nextInt(2)+1;
		
		switch (n) {

		case 1:
			System.out.println("--------------------------");
			System.out.println("Order is delivered");
			break;
		case 2:
			System.out.println("--------------------------");
			System.out.println("Order in transport");
			break;

		default:
			System.out.println("--------------------------");
			System.out.println("Order in processing for shipig");
		}}while(n!=1);
	}

}
