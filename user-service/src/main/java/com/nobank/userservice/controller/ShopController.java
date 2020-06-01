package com.nobank.userservice.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nobank.userservice.model.Bill;
import com.nobank.userservice.model.Product;
import com.nobank.userservice.service.ProductServices;
import com.nobank.userservice.service.UserServices;

@Controller
public class ShopController {
	
	@Autowired
	private ProductServices productServices;
	
	@Autowired
	private UserServices userServices;
	
	@GetMapping("/shop")
    public String viewShop(Model model, Principal principal) {
    	
    	String user = principal.getName();
    	
    	List<Product> products =productServices.getProducts();
    	Map<String, Object> map = new HashMap<>();
    	
    	map.put("name", userServices.getUserByEmail(user).getName());
    	map.put("products", products);
    	map.put("len", products.size());
    	map.put("MODE", "shop");
    	model.addAllAttributes(map);
    	return "shop";
    } 

    @GetMapping("/shop/{productId}")
    public String getProduct(@PathVariable String productId, Model model, Principal principal){
    	String username = principal.getName();
    	
    	Product product = productServices.getProduct(productId);
    	List<Bill> bills = productServices.getBill(productId);
    	Map<String, Object> map = new HashMap<>();
    	
    	map.put("name", userServices.getUserByEmail(username).getName());
    	map.put("product", product);
    	map.put("MODE" , "shop");
    	map.put("bills", bills);
    	map.put("size", bills.size());
    	model.addAllAttributes(map);

        return "shop-item";
    }
    
    @PostMapping("/buy")
    public String buyProd() {
    	
    	return "shop-item";
    }

    
}
