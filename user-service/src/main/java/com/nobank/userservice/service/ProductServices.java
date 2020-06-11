package com.nobank.userservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nobank.userservice.model.Bill;
import com.nobank.userservice.model.Product;
import com.nobank.userservice.model.Quantity;

@Service
public class ProductServices {
	
	private final String webURL="https://product-service0.herokuapp.com/";
	private final String localURL = "http://localhost:8200/";
	
	public List<Product> getProductsFallback(){
		return new ArrayList<>();
	}

	@HystrixCommand(fallbackMethod = "getProductsFallback")
    public List<Product> getProducts(){

        ResponseEntity<Product[]> responseEntity = new RestTemplate()
                .getForEntity(localURL+"products/", Product[].class);

            List<Product> list = Arrays.asList(responseEntity.getBody());
            
            return list;

    }


    public Product getProduct(String productId){

        Map<String, String> pathVarmap = new HashMap<>();

        pathVarmap.put("productId", productId);

        ResponseEntity<Product> responseEntity = new RestTemplate()
                .getForEntity(localURL+"products/{productId}", Product.class, pathVarmap);

            return responseEntity.getBody();
    }

    public Product createProduct(String userId, Product product){

        return null;
    }
    
    public void updateProduct(String productId, String userId, Quantity quantity){
    	
    	Map<String, String> pathVar = new HashMap<>();
    	pathVar.put("productId", productId);
    	pathVar.put("userId", userId);
    	
    	new RestTemplate()
    			.put(localURL+"products/{productId}",quantity,pathVar);
    	
    }

    public Product deleteProduct(String productId){

        return null;
    }
    
    public List<Bill> getBill(String productId){
    	Map<String, String> pathVarmap = new HashMap<>();
    	pathVarmap.put("productId", productId);
    	ResponseEntity<Bill[]> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:8500/fee/product/{productId}", Bill[].class, pathVarmap);

            return Arrays.asList(responseEntity.getBody());
    }
    
    public Bill postBill(Bill bill) {
    	ResponseEntity<Bill> entity = new RestTemplate()
    		.postForEntity("", bill, Bill.class);
    	return entity.getBody();
    }
}
