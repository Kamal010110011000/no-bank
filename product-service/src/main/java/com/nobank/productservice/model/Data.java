package com.nobank.productservice.model;

public class Data {

    private Bill bill;
    private Product product;

    public Data(){}

    public Data(Product product, Bill bill) {
        this.bill = bill;
        this.product = product;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
