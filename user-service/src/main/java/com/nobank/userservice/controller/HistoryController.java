package com.nobank.userservice.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nobank.userservice.model.History;
import com.nobank.userservice.service.UserServices;

@Controller
public class HistoryController {
	
	@Autowired
	private UserServices userServices;
	
	@GetMapping(value="/history")
	public String getHistory(Model model, Principal principal) {
		String user = principal.getName();
		List<History> history = userServices.getHistory(user);
		Map<String, Object> map = new HashMap<>();
		map.put("MODE", "history");
		map.put("name", userServices.getUserByEmail(user).getName());
		map.put("history", history);
		
		model.addAllAttributes(map);
		
		return "history";
	}
	
	

}
