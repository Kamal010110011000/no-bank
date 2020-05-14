package com.nobank.productservice.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.nobank.productservice.model.Holder;
import com.nobank.productservice.model.Product;

@Service
public class DBinit implements CommandLineRunner{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		productRepository.deleteAll();
		
		List<Holder> holders = new ArrayList<>();
		
		Product product1 = new Product("Reb Bus", "no-image",holders, 5000, 400, "SOME DISCRIPTION");
		Product product2 = new Product("Swiggy", "no-image",holders, 4000, 500,"SOME DISCRIPTION");
		Product product3 = new Product("NetMeds", "no-image",holders, 1200, 400,"SOME DISCRIPTION");
		Product product4 = new Product("Dominos", "no-image",holders, 4500, 400,"SOME DISCRIPTION");
		Product product5 = new Product("Ola", "no-image",holders, 4300, 400,"SOME DISCRIPTION");
		Product product6 = new Product("Oyo", "no-image",holders, 7800, 400,"SOME DISCRIPTION");
		
		List<Product> products = Arrays.asList(product1,product2,product3, product4, product5, product6);
		
		productRepository.saveAll(products);
	}

}
