package com.nobank.productservice.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.nobank.productservice.model.Bill;
import com.nobank.productservice.model.Data;
import com.nobank.productservice.model.Holder;
import com.nobank.productservice.model.Product;
import com.nobank.productservice.service.ProductService;

@Service
public class DBinit implements CommandLineRunner{
	
	@Autowired
	private ProductService productService;

	@Override
	public void run(String... args) throws Exception {
		
		List<Holder> holders = new ArrayList<>();
		
		Product product1 = new Product("Reb Bus", "no-image",holders, 5000, 400, "SOME DISCRIPTION");
		Product product2 = new Product("Swiggy", "no-image",holders, 4000, 500,"SOME DISCRIPTION");
		Product product3 = new Product("NetMeds", "no-image",holders, 1200, 400,"SOME DISCRIPTION");
		Product product4 = new Product("Dominos", "no-image",holders, 4500, 400,"SOME DISCRIPTION");
		Product product5 = new Product("Ola", "no-image",holders, 4300, 400,"SOME DISCRIPTION");
		Product product6 = new Product("Oyo", "no-image",holders, 7800, 400,"SOME DISCRIPTION");
		
		Data data1=new Data(product1, new Bill("1234",100 , 120 , 15));
		Data data2=new Data(product2, new Bill("1234",100 , 120 , 15));
		Data data3=new Data(product3, new Bill("1234",100 , 120 , 15));
		Data data4=new Data(product4, new Bill("1234",100 , 120 , 15));
		Data data5=new Data(product5, new Bill("1234",100 , 120 , 15));
		Data data6=new Data(product6, new Bill("1234",100 , 120 , 15));
		
		List<Data> data = Arrays.asList(data1,data2,data3,data4,data5,data6);
		
		
		
	}

}
