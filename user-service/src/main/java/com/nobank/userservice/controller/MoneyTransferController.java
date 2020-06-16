package com.nobank.userservice.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nobank.userservice.model.User;
import com.nobank.userservice.service.HistoryService;
import com.nobank.userservice.service.UserServices;

@Controller
public class MoneyTransferController {
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private HistoryService historyService;
	
	@GetMapping("/transfer-money")
    public String getTransferMoneyPage(Model model, Principal principal) {
    	String email = principal.getName();
    	User user = userServices.getUserByEmail(email);
    	Map<String, Object> map=new HashMap<>();
    	map.put("user", user);
    	map.put("msg","");
    	map.put("submode", "transfer");
    	model.addAllAttributes(map);
    	
    	return "transfer";
    }
	
	@PostMapping("/transfer-money")
	public String transferMoney(@RequestParam("to") String to,
								@RequestParam("amount") String amount,
								@RequestParam("use") String use,
								Principal principal,
								Model model) {
		double amt = Double.parseDouble(amount);
		String user_email = principal.getName();
		User user = userServices.getUserByEmail(user_email); 
		Map<String, Object> map = new HashMap<>();
		if(user.getAccount().getBalance()<Double.parseDouble(amount)) {
			map.put("msg", "You Dont have Enough Balance");
		}else {
			map.put("msg", "Something Went Wrong");
			if(use.matches("Email")) {
				user = historyService.updateHistoryByEmail(user_email, to, amt);
				map.put("msg", "Money Transferred Successfully!");
			}
			else if(use.matches("Account No")) {
				long ac = Long.parseLong(to);
				user = historyService.updateHistoryByAc(user_email, to, amt);
				map.put("msg", "Money Transferred Successfully!");
			}
		}

		map.put("user", user);
		map.put("submode", "transfer");
		model.addAllAttributes(map);
		return "transfer";
	}
	
	

}
