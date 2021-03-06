package com.nobank.userservice.model;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    private String id;

    private String name;

    private String email;

    private String password;

    private List<String> roles;

    private List<String> permissions;

    private long aadhar_no;

    private String imageUrl;

    private Card card;
    
    private long phone;

    private Address address;

    private Account account;

    private int active = 1;


    private	List<String> forSale;
    private List<Product> products;
    private LinkedList<History> history;
 
    public User(String name, String email, List<Product> products,List<String> forSale,
                long aadhar_no, long phone, Address address, String imageUrl, String password,
                Account account, LinkedList<History> history, List<String> roles,List<String> permissions, Card card) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.forSale = forSale;
        this.products = products;
        this.aadhar_no = aadhar_no;
        this.phone = phone;
        this.address = address;
        this.roles = roles;
        this.imageUrl = imageUrl;
        this.account = account;
        this.history = history;
        this.permissions = permissions;
        this.card = card;
    }

    

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getForSale() {
        return forSale;
    }

    public void setForSale(List<String> forSale) {
        this.forSale = forSale;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getAadhar_no() {
        return aadhar_no;
    }

    public void setAadhar_no(long aadhar_no) {
        this.aadhar_no = aadhar_no;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LinkedList<History> getHistory() {
        return history;
    }

    public void setHistory(LinkedList<History> history) {
        this.history = history;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
    
    

    public Card getCard() {
		return card;
	}



	public void setCard(Card card) {
		this.card = card;
	}



	@Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", permissions=" + permissions +
                ", aadhar_no=" + aadhar_no +
                ", imageUrl='" + imageUrl + '\'' +
                ", phone=" + phone +
                ", address=" + address.toString() +
                ", account=" + account.toString() +
                ", active=" + active +
                ", forSale=" + forSale +
                ", products=" + products +
                ", history=" + history +
                '}';
    }
}
