package com.nobank.userservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nobank.userservice.model.Order;

@Service
public class OrderService {

	String localurl = "http://localhost:8400/orders";
	
	public String FallBack() {
		return "No Service Avialable";
	}
	
	
//	@HystrixCommand(fallbackMethod = "FallBack")
	public String placeOrder(Order order) {
		try {
			ResponseEntity<Order> entity = new RestTemplate()
					.postForEntity(localurl, order, Order.class);
				
				return "success";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "Service Not Available";
		}
		

	}
	

}
