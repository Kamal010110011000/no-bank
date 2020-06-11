package com.nobank.userservice.model;

import java.util.Date;

public class Card {
	
	public enum cardType {
		Debit, Credit
	}
	
	public cardType type;
	public long no;
	public Date issuedOn;
	public Date expireOn;
	public int cvv;
	public int pin;
	public boolean active;
	
	public Card() {}
	
	public Card(cardType type, long no, Date issuedOn, Date expireOn, int cvv, int pin) {
		super();
		this.type = type;
		this.no = no;
		this.issuedOn = issuedOn;
		this.expireOn = expireOn;
		this.cvv = cvv;
		this.pin = pin;
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
	public Date getIssuedOn() {
		return issuedOn;
	}
	public void setIssuedOn(Date issuedOn) {
		this.issuedOn = issuedOn;
	}
	public Date getExpireOn() {
		return expireOn;
	}
	public void setExpireOn(Date expireOn) {
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
	
	

}
