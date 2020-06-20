package com.nobank.userservice.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.nobank.userservice.model.History.TransferType;



public class Order {

    @Id
    private String id;
    private String userId;
    private TransferType  type;
    private String cradentials;
    private int funds;
    private LocalDateTime date;
    
    public Order() {}
    
	public Order(String userId, TransferType type, int amount, LocalDateTime date, String cradentials) {
		this.userId = userId;
		this.type = type;
		this.funds = amount;
		this.date = date;
		this.cradentials = cradentials;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public TransferType getType() {
		return type;
	}

	public void setType(TransferType type) {
		this.type = type;
	}

	public String getCradentials() {
		return cradentials;
	}

	public void setCradentials(String cradentials) {
		this.cradentials = cradentials;
	}

	public int getFunds() {
		return funds;
	}

	public void setFunds(int funds) {
		this.funds = funds;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", type=" + type + ", cradentials=" + cradentials + ", funds="
				+ funds + ", date=" + date + "]";
	}
	
	

}
