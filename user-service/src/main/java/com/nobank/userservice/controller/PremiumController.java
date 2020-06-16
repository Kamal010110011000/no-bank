package com.nobank.userservice.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nobank.userservice.model.User;
import com.nobank.userservice.service.UserServices;

@RequestMapping("premium")
public class PremiumController {
	
	@Autowired
	private UserServices userServices;
	
	@GetMapping("/lic-premium")
    public String licPremium(Model model, Principal principal) {
    	String email = principal.getName();
    	User user = userServices.getUserByEmail(email);
    	Map<String, Object> map=new HashMap<>();
    	map.put("user", user);
    	map.put("msg","");
    	map.put("submode", "lic");
    	model.addAllAttributes(map);
    	
    	return "transfer";
    }
	
	
	
	
	
	@GetMapping("/insurance-premium")
    public String insurancePremium(Model model, Principal principal) {
    	String email = principal.getName();
    	User user = userServices.getUserByEmail(email);
    	Map<String, Object> map=new HashMap<>();
    	map.put("user", user);
    	map.put("msg","");
    	map.put("submode", "insurance");
    	model.addAllAttributes(map);
    	
    	return "transfer";
    }

}
