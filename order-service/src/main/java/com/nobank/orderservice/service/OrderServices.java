package com.nobank.orderservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nobank.orderservice.model.Order;
import com.nobank.orderservice.repository.OrderRepository;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Order order){
        return orderRepository.save(order);
    }

    //public List<Order> getOrders(String userId){
        //List<Order> orders = (List<Order>) orderRepository.findByUserId(userId);

      //  return orders;
    //}
    
    public List<Order> getOrders(){
    	return orderRepository.findAll();
    }

    public Map<String, Object> deleteOrder(String orderId){
        Optional<Order> orderList = orderRepository.findById(orderId);
        Order order = orderList.get();
        orderRepository.delete(order);

        //TODO: update Product data

        Map<String, Object> map = new HashMap<>();
        map.put("message", "order deleted successfully");
        map.put("order", order);

        return map;
    }
}
