package com.nobank.userservice.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nobank.userservice.model.History;
import com.nobank.userservice.model.History.TransferType;
import com.nobank.userservice.model.Order;
import com.nobank.userservice.model.User;
import com.nobank.userservice.service.HistoryService;
import com.nobank.userservice.service.OrderService;
import com.nobank.userservice.service.UserServices;
import com.nobank.userservice.service.UtilServices;

@Controller
@RequestMapping("recharge")
public class RechargeController {
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UtilServices utilServices;
	
	@Autowired
	private HistoryService historyServices;

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
	
	@PostMapping("/mobile-recharge")
	public String doMobileRecharge(Model model, Principal principal, @ModelAttribute("mob") String mob, @ModelAttribute("amount") String amount ){
		String email = principal.getName();
    	User user = userServices.getUserByEmail(email);
    	
    	Order order = new Order(user.getId(),TransferType.MobileRecharge,Integer.parseInt(amount), LocalDateTime.now(),mob);
    	Map<String, Object> map=new HashMap<>();
    	if(utilServices.canPay(email, Double.parseDouble(amount))){
    		String str = orderService.placeOrder(order);
    		if(str.equals("success")){
    			map.put("msg","Recharge Successfull");
    			History history = new History(LocalDateTime.now(),Double.parseDouble(amount),mob,TransferType.MobileRecharge);
    			historyServices.AddHistory(history, email);
    		}
    		else {
    			map.put("msg",str);
    		}
    		
    	}
    	else {
    		map.put("msg","Dont have Enough Money");
    	}
    	
    	map.put("user", user);
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
