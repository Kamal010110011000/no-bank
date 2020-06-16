package com.nobank.userservice.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nobank.userservice.model.User;
import com.nobank.userservice.service.UserServices;

public class DonationController {
	
	@Autowired
	private UserServices userServices;

	@GetMapping("/donation")
    public String donation(Model model, Principal principal) {
    	String email = principal.getName();
    	User user = userServices.getUserByEmail(email);
    	Map<String, Object> map=new HashMap<>();
    	map.put("user", user);
    	map.put("msg","");
    	map.put("submode", "donate");
    	model.addAllAttributes(map);
    	
    	return "transfer";
    }
}
