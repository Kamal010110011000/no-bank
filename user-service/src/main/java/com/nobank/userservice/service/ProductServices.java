package com.nobank.userservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nobank.userservice.model.Product;

@Service
public class ProductServices {
	
	private final String localURL="http://product-service";
	private final String webURL="";
	


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
                .getForEntity("http://localhost:8200/products/{productId}", Product.class, pathVarmap);

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
