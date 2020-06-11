package com.nobank.userservice.model;


import java.time.LocalDateTime;

public class History {

    public enum TransferType{
        Debit, Credit, Invest
    }

    private LocalDateTime date;

    private double funds;

    private String otherUser;

    private TransferType type;

    private boolean status;


    public History(){}

    public History(LocalDateTime date, double funds, String otherUser, TransferType type) {
        this.date = date;
        this.funds = funds;
        this.otherUser = otherUser;
        this.type = type;
        this.status = false;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public String getUser() {
        return otherUser;
    }

    public void setUser(String otherUser) {
        this.otherUser = otherUser;
    }

    public TransferType getType() {
        return type;
    }

    public void setType(TransferType type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOtherUser() {
        return otherUser;
    }

    public void setOtherUser(String otherUser) {
        this.otherUser = otherUser;
    }

	@Override
	public String toString() {
		return "History [date=" + date + ", funds=" + funds + ", otherUser=" + otherUser + ", type=" + type
				+ ", status=" + status + "]";
	}
    
    
}
