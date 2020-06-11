package com.nobank.userservice.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nobank.userservice.model.Account;
import com.nobank.userservice.model.Product;
import com.nobank.userservice.model.User;
import com.nobank.userservice.service.ProductServices;
import com.nobank.userservice.service.UserServices;

@Controller
public class UserController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private ProductServices productServices;


    @GetMapping("login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/")
    public String homePage(Model model, Principal principal){

        String user = principal.getName();

        Map<String, Object> map = new HashMap<>();

        map.put("HOME", "active");
        map.put("user", userServices.getUserByEmail(user));
        map.put("MODE","DASHBOARD");
        model.addAllAttributes(map);

        return "index";
    }
    
    @GetMapping("/register")
    public String createUser(Model model) {
    	model.addAttribute("success_message", "");
    	return "register";
    }
    
    @PostMapping("/register")
    public String createUser(@ModelAttribute User user , Model model) {
    	String password = new BCryptPasswordEncoder().encode(user.getPassword());
    	Account account = new Account(user.getAccount().getType(),1000);
    	List<String> role = new ArrayList<>();
    	role.add("user");
    	user.setAccount(account);
    	user.setRoles(role);
    	user.setActive(1);
    	user.setPassword(password);
    	userServices.createUser(user);
    	model.addAttribute("success_message", "Account Created Successfully!");
    	return "register";
    }
    
    @GetMapping("/my-investments")
    public String myInvestments(Model model, Principal principal) {
    	User user = userServices.getUserByEmail(principal.getName());
    	Map<String, Object> map = new HashMap<>();
    	List<Product> products = new ArrayList<>();
    	for(String s: user.getProducts()) {
    		products.add(productServices.getProduct(s));
    	}
    	map.put("name", user.getName());
    	map.put("products", products);
    	map.put("MODE", "my-investment"); 
    	model.addAllAttributes(map);
    	return "my-products";
    	
    }
    
    


}
