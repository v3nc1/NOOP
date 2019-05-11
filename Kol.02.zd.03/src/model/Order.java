package model;

import java.io.Serializable;

public class Order implements Serializable {
	
	
	private int productCat;
	private boolean giftCard;
	private boolean decorativePack;
	private boolean newLetter;
	private String paymentMet;
	private String gcText;
	private String delivery;
	
	
	public Order(int productCat, boolean giftCard, boolean decorativePack, boolean newLetter, String paymentMet,
			String gcText, String delivery) {
		super();
		this.productCat = productCat;
		this.giftCard = giftCard;
		this.decorativePack = decorativePack;
		this.newLetter = newLetter;
		this.paymentMet = paymentMet;
		this.gcText = gcText;
		this.delivery = delivery;
	}


	public int getProductCat() {
		return productCat;
	}


	public boolean isGiftCard() {
		return giftCard;
	}


	public boolean isDecorativePack() {
		return decorativePack;
	}


	public boolean isNewLetter() {
		return newLetter;
	}


	public String getPaymentMet() {
		return paymentMet;
	}


	public String getGcText() {
		return gcText;
	}


	public String getDelivery() {
		return delivery;
	}
	
	
	
	
	
	

}
