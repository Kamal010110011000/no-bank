package com.nobank.feeservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bill {

    @Id
    private String id;
    private String userId;
    private String productId;
    private double face_value;
    private double market_value;
    private double dividend;
    private boolean status = true;

    public Bill(){}

    public Bill(String id, String userId, String productId, double face_value, double market_value, double dividend, boolean status) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.face_value = face_value;
        this.market_value = market_value;
        this.dividend = dividend;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getFace_value() {
        return face_value;
    }

    public void setFace_value(double face_value) {
        this.face_value = face_value;
    }

    public double getMarket_value() {
        return market_value;
    }

    public void setMarket_value(double market_value) {
        this.market_value = market_value;
    }

    public double getDividend() {
        return dividend;
    }

    public void setDividend(double dividend) {
        this.dividend = dividend;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
    
    
}
