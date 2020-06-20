package com.nobank.userservice.model;

public class Card {
	
	public enum cardType {
		Debit, Credit
	}
	
	private cardType type;
	private long no;
	private String issuedOn;
	private String expireOn;
	private int cvv;
	private int pin;
	private boolean active;
	
	public Card() {}
	
	public Card(cardType type, long no, String issuedOn, String expireOn, int cvv, int pin, boolean active) {
		super();
		this.type = type;
		this.no = no;
		this.issuedOn = issuedOn;
		this.expireOn = expireOn;
		this.cvv = cvv;
		this.pin = pin;
		this.active = active;
	}




	public cardType getType() {
		return type;
	}
	public void setType(cardType type) {
		this.type = type;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getIssuedOn() {
		return issuedOn;
	}
	public void setIssuedOn(String issuedOn) {
		this.issuedOn = issuedOn;
	}
	public String getExpireOn() {
		return expireOn;
	}
	public void setExpireOn(String expireOn) {
		this.expireOn = expireOn;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String cardNo() {
		String str = String.valueOf(this.no);
		return str.substring(0, 4)+" "+str.substring(4, 8)+" "+str.substring(8);
	}
	
	

}
