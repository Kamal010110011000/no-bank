package com.nobank.orderservice.repository;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.nobank.orderservice.model.Order;
import com.nobank.orderservice.model.Order.TransferType;
import com.nobank.orderservice.service.OrderServices;

@Service
public class DBinit implements CommandLineRunner{
	
	@Autowired
	private OrderServices orderServices;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		orderRepository.deleteAll();
		Order order = new Order("123456", 
				TransferType.MobileRecharge,30, LocalDateTime.now(), "8987667676" );
		
		orderServices.placeOrder(order);
		
		System.out.println(orderServices.getOrders());
		
	}
	
	

}
