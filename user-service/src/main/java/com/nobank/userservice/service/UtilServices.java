package com.nobank.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nobank.userservice.repository.UserRepository;

@Service
public class UtilServices {
	
	@Autowired
	private UserRepository userRepo;
	
	public boolean canPay(String user, double amount){
		double bal = userRepo.findByEmail(user).getAccount().getBalance();
		if(amount >= bal) {
			return false;
		}
		return true;
	}
	
	

}
