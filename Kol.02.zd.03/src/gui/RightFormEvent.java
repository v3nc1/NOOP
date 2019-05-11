package gui;
import java.util.EventObject;

import javax.swing.JButton;

public class RightFormEvent extends EventObject {
	 private int productCat;
	 private boolean giftCard;
	 private boolean decorativePack;
	 private boolean newLetter;
	 private String paymentMet;
	 private String gcText;
	 private String delivery;

	public RightFormEvent(JButton source) {
		super(source);
	}

	public int getProducrCat() {
		return productCat;
	}

	public void setProducrCat(int producrCat) {
		this.productCat = producrCat;
	}

	public boolean isGiftCard() {
		return giftCard;
	}

	public void setGiftCard(boolean giftCard) {
		this.giftCard = giftCard;
	}

	public boolean isDecorativePack() {
		return decorativePack;
	}

	public void setDecorativePack(boolean decorativePack) {
		this.decorativePack = decorativePack;
	}

	public boolean isNewLetter() {
		return newLetter;
	}

	public void setNewLetter(boolean newLetter) {
		this.newLetter = newLetter;
	}

	public String getPaymentMet() {
		return paymentMet;
	}

	public void setPaymentMet(String paymentMet) {
		this.paymentMet = paymentMet;
	}

	public String getGcText() {
		return gcText;
	}

	public void setGcText(String gcText) {
		this.gcText = gcText;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}


}





