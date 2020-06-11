package com.nobank.orderservice.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
	
	public enum Type{
		MobileRecharge, DthRecharge, ElectricityBill, CraditCardBill, LICPremium,
		LandlineBill, Donated, WaterBill, BroadBandBill, PipedGasBill, InsurencePremium 
	}

    @Id
    private String id;
    private String no;
    private Type  type;
    private int amount;
    private LocalDateTime date;
    
    public Order() {}
    
	public Order(String no, Type type, int amount, LocalDateTime date) {
		this.no = no;
		this.type = type;
		this.amount = amount;
		this.date = date;
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
    
	
    
    
}
