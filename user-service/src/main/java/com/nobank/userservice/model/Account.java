package com.nobank.userservice.model;

public class Account {

    public enum Type {
        Saving, Current
    }

    private long acNo;

    private double balance;
    
    private String ifsc;

    private Type type;

    public Account(){}

    public Account(Type type,double balance) {
        this.acNo = System.currentTimeMillis();
        this.type = type;
        this.balance = balance;
        this.ifsc = "";
    }

    public long getAcNo() {
        return acNo;
    }

    public void setAcNo(long ac_no) {
        this.acNo = ac_no;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	@Override
	public String toString() {
		return "Account [ac_no=" + acNo + ", balance=" + balance + ", type=" + type + "]";
	}
    
    
}
