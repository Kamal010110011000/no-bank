package com.nobank.orderservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nobank.orderservice.model.Order;
import com.nobank.orderservice.service.OrderServices;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderServices orderServices;

    @PostMapping()
    public Order doRecharge(@RequestBody Order order){
    	return orderServices.placeOrder(order);
    }
    
    @GetMapping()
    public List<Order> getOrder() {
    	return orderServices.getOrders();
    }
}
