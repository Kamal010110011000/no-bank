package com.nobank.orderservice.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
	
	public enum TransferType{
		MobileRecharge, DthRecharge, ElectricityBill, CraditCardBill, LICPremium,
		LandlineBill, Donated, WaterBill, BroadBandBill, PipedGasBill, InsurencePremium 
	}

    @Id
    private String id;
    private String otherUser;
    private TransferType  type;
    private int funds;
    private LocalDateTime date;
    
    public Order() {}
    
	public Order(String no, TransferType type, int amount, LocalDateTime date) {
		this.otherUser = no;
		this.type = type;
		this.funds = amount;
		this.date = date;
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getOtherUser() {
		return otherUser;
	}
	public void setOtherUser(String no) {
		this.otherUser = no;
	}
	public TransferType getType() {
		return type;
	}
	public void setType(TransferType type) {
		this.type = type;
	}
	public int getFunds() {
		return funds;
	}
	public void setFunds(int amount) {
		this.funds = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
    
	
    
    
}
