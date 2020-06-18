package com.nobank.userservice.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nobank.userservice.model.Card;
import com.nobank.userservice.model.Card.cardType;
import com.nobank.userservice.model.User;
import com.nobank.userservice.service.CardServices;
import com.nobank.userservice.service.UserServices;

@Controller
@RequestMapping("card")
public class CardController {
	
	@Autowired
	private CardServices cardServices;
	
	@Autowired
	private UserServices userServices;
	
	@GetMapping()
	public String requestCard(Model model, Principal principal) {
		Map<String, Object> map = new HashMap<>(); 
		String name = principal.getName();
		User user = userServices.getUserByEmail(name);
		map.put("user", user);
		map.put("MODE", "card"); 
		model.addAllAttributes(map);
		
		return "card";
	}
	
	@PostMapping()
	public String generateCard(Principal principal, Model model, @ModelAttribute("pin") String pin) {
		String email = principal.getName();
		Map<String, Object> map = new HashMap<>();
		Card card = cardServices.createCard(email, Integer.parseInt(pin));
		map.put("user", userServices.getUserByEmail(email));
		map.put("MODE", "card");
		model.addAllAttributes(map);
		return "card";
	
	}

}
