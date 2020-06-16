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

@RequestMapping("pay-bill")
public class BillingController {
	
	@Autowired
	private UserServices userServices;

	@GetMapping("/electricity-bill")
    public String electricityBill(Model model, Principal principal) {
    	String email = principal.getName();
    	User user = userServices.getUserByEmail(email);
    	Map<String, Object> map=new HashMap<>();
    	map.put("user", user);
    	map.put("msg","");
    	map.put("submode", "electricity");
    	model.addAllAttributes(map);
    	
    	return "transfer";
    }
	
	@GetMapping("/craditcard-bill")
    public String craditcardBill(Model model, Principal principal) {
    	String email = principal.getName();
    	User user = userServices.getUserByEmail(email);
    	Map<String, Object> map=new HashMap<>();
    	map.put("user", user);
    	map.put("msg","");
    	map.put("submode", "craditcard");
    	model.addAllAttributes(map);
    	
    	return "transfer";
    }
	
	@GetMapping("/water-bill")
    public String waterBill(Model model, Principal principal) {
    	String email = principal.getName();
    	User user = userServices.getUserByEmail(email);
    	Map<String, Object> map=new HashMap<>();
    	map.put("user", user);
    	map.put("msg","");
    	map.put("submode", "waterbill");
    	model.addAllAttributes(map);
    	
    	return "transfer";
    }
	
	
	
	@GetMapping("/pipedgas-bill")
    public String pipedgasBill(Model model, Principal principal) {
    	String email = principal.getName();
    	User user = userServices.getUserByEmail(email);
    	Map<String, Object> map=new HashMap<>();
    	map.put("user", user);
    	map.put("msg","");
    	map.put("submode", "pipedgas");
    	model.addAllAttributes(map);
    	
    	return "transfer";
    }
	
}
