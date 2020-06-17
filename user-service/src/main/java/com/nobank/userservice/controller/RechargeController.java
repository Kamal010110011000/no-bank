package com.nobank.userservice.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nobank.userservice.model.User;
import com.nobank.userservice.service.UserServices;

@Controller
@RequestMapping("recharge")
public class RechargeController {
	
	@Autowired
	private UserServices userServices;

	@GetMapping("/mobile-recharge")
    public String getMobileRecharge(Model model, Principal principal) {
    	String email = principal.getName();
    	User user = userServices.getUserByEmail(email);
    	Map<String, Object> map=new HashMap<>();
    	map.put("user", user);
    	map.put("msg","");
    	map.put("submode", "mobile");
    	model.addAllAttributes(map);
    	
    	return "transfer";
    }
	
	@GetMapping("/dth-recharge")
    public String dthRecharge(Model model, Principal principal) {
    	String email = principal.getName();
    	User user = userServices.getUserByEmail(email);
    	Map<String, Object> map=new HashMap<>();
    	map.put("user", user);
    	map.put("msg","");
    	map.put("submode", "dth");
    	model.addAllAttributes(map);
    	
    	return "transfer";
    }
	
	@GetMapping("/broadband-recharge")
    public String broadbandRecharge(Model model, Principal principal) {
    	String email = principal.getName();
    	User user = userServices.getUserByEmail(email);
    	Map<String, Object> map=new HashMap<>();
    	map.put("user", user);
    	map.put("msg","");
    	map.put("submode", "broadband");
    	model.addAllAttributes(map);
    	
    	return "transfer";
    }
	
	@GetMapping("/landline")
    public String landLine(Model model, Principal principal) {
    	String email = principal.getName();
    	User user = userServices.getUserByEmail(email);
    	Map<String, Object> map=new HashMap<>();
    	map.put("user", user);
    	map.put("msg","");
    	map.put("submode", "landline");
    	model.addAllAttributes(map);
    	
    	return "transfer";
    }
}
