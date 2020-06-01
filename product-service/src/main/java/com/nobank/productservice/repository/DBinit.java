package com.nobank.productservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.nobank.productservice.model.Bill;
import com.nobank.productservice.model.Holder;
import com.nobank.productservice.model.Product;
import com.nobank.productservice.service.ProductService;

@Service
public class DBinit implements CommandLineRunner{
	
	@Autowired
	private ProductService productService;


	@Override
	public void run(String... args) throws Exception {
		
		productService.deleteAll();
		
		List<Holder> holders = new ArrayList<>();
		
		Product product1 = new Product("Reb Bus", "no-image",holders, 5000, 400, "SOME DISCRIPTION");
		Product product2 = new Product("Swiggy", "no-image",holders, 4000, 500,"SOME DISCRIPTION");
		Product product3 = new Product("NetMeds", "no-image",holders, 1200, 400,"SOME DISCRIPTION");
		Product product4 = new Product("Dominos", "no-image",holders, 4500, 400,"SOME DISCRIPTION");
		Product product5 = new Product("Ola", "no-image",holders, 4300, 400,"SOME DISCRIPTION");
		Product product6 = new Product("Oyo", "no-image",holders, 7800, 400,"SOME DISCRIPTION");
		
		Bill bill =  new Bill(null,100 , 120 , 10);
		Bill bill2 =  new Bill(null,150 , 200 , 5);
		Bill bill3 = new Bill(null,160 , 180 , 12);
		Bill bill4= new Bill(null,170 , 190 , 7);
		Bill bill5= new Bill(null,180 , 200 , 5);
		Bill bill6= new Bill(null,120 , 150 , 25);
		
		productService.createProduct(product1, bill);
		productService.createProduct(product2, bill2);
		productService.createProduct(product3, bill3);
		productService.createProduct(product4, bill4);
		productService.createProduct(product5, bill5);
		productService.createProduct(product6, bill6);
		
		
		
	}

}
