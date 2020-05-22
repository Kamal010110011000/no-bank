package com.nobank.productservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nobank.productservice.model.Bill;

@Service
public class BillServices {
	
	private final String bill_url = "http://localhost:8500";
	
	
	public Bill postBill(Bill bill) {
		
		ResponseEntity<Bill> entity = new RestTemplate()
				.postForEntity(bill_url+"/fee", bill, Bill.class);
		
		return entity.getBody();
	}
	
	

}
