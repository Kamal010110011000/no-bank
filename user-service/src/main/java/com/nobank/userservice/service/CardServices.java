package com.nobank.userservice.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nobank.userservice.model.Card;
import com.nobank.userservice.model.Card.cardType;
import com.nobank.userservice.model.User;
import com.nobank.userservice.repository.UserRepository;

@Service
public class CardServices {
	
	@Autowired
	private UserRepository userRepository;
	
	public Card createCard(String email, cardType type, int pin) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String date = formatter.format(new Date());
		Card card = new Card(type, generateNo(),date,generateExpiryDate(date),generateCVV(), pin);
		
		User user= userRepository.findByEmail(email);
		user.setCard(card);
		userRepository.save(user);
		
		return card;
	}
	
	public int generateCVV() {
		int cvv = (int)(Math.random()*1000)+(int)(System.currentTimeMillis()%1000);
		return cvv%1000;
	}
	
	public long generateNo() {
		long no = (long)(Math.random()*Long.parseLong("1000000000000"))+System.currentTimeMillis();
		return no%Long.parseLong("10000000000000");
	}
	
	public String generateExpiryDate(String date) {
		int year = Integer.parseInt(date.split("/")[2]);
		int month = Integer.parseInt(date.split("/")[1]);
		int day = Integer.parseInt(date.split("/")[0]);
		year += 8;
		String str = day+"/"+month+"/"+year;
		return str;
	}

}
