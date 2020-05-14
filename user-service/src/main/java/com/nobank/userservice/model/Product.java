package com.nobank.userservice.model;

public class Product {

    private String id;
    
    private String name;
    
    private String imageUrl;

    private String discription;


    public Product(){}


	public Product(String id, String name, String imageUrl, String discription) {
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.discription = discription;
	}


	


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getDiscription() {
		return discription;
	}


	public void setDiscription(String discription) {
		this.discription = discription;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", discription=" + discription + "]";
	}

    
    
}
