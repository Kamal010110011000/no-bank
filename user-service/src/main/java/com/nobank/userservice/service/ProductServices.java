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
import com.nobank.userservice.model.Product;

@Service
public class ProductServices {
	
	private final String webURL="https://product-service0.herokuapp.com/";
	
	
	public List<Product> getProductsFallback(){
		return new ArrayList<>();
	}

	@HystrixCommand(fallbackMethod = "getProductsFallback")
    public List<Product> getProducts(){

        ResponseEntity<Product[]> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:8200/products/", Product[].class);

            List<Product> list = Arrays.asList(responseEntity.getBody());
            
            return list;

    }


    public Product getProduct(String productId){

        Map<String, String> pathVarmap = new HashMap<>();

        pathVarmap.put("productId", productId);

        ResponseEntity<Product> responseEntity = new RestTemplate()
                .getForEntity(webURL+"products/{productId}", Product.class, pathVarmap);

            return responseEntity.getBody();
    }

    public Product createProduct(String userId, Product product){

        return null;
    }
    public Product updateProduct(String productId, Product Product){

        return null;
    }

    public Product deleteProduct(String productId){

        return null;
    }
}
