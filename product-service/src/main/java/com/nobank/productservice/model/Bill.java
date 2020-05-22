package com.nobank.productservice.model;

public class Bill {
    private String userId;
    private String productId;
    private double face_value;
    private double market_value;
    private double dividend;

    public Bill() {
    }

    public Bill(String userId, double face_value, double market_value, double dividend) {
        this.userId = userId;
        this.face_value = face_value;
        this.market_value = market_value;
        this.dividend = dividend;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
