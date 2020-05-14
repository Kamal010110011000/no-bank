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
    	map.put("MODE", "shop");
    	model.addAllAttributes(map);
    	return "shop";
    } 

    @GetMapping("/shop/{productId}")
    public String getProduct(@PathVariable String productId, Model model){
    	
        return "shop-item";
    }

}
