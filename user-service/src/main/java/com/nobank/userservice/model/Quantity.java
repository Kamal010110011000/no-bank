package com.nobank.userservice.model;

public class Quantity {
	
	private String user1Id;
	private String user2Id;
	private int quantity;
	
	public Quantity() {}
	
	public Quantity(String user1Id, String user2Id, int quantity) {
		super();
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.quantity = quantity;
	}
	public String getUser1Id() {
		return user1Id;
	}
	public void setUser1Id(String user1Id) {
		this.user1Id = user1Id;
	}
	public String getUser2Id() {
		return user2Id;
	}
	public void setUser2Id(String user2Id) {
		this.user2Id = user2Id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
