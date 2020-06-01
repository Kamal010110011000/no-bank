package com.nobank.feeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nobank.feeservice.model.Bill;
import com.nobank.feeservice.service.BillingServices;

@RestController
@RequestMapping(value = "/fee")
public class BillController {

    @Autowired
    private BillingServices billingServices;


    @GetMapping(value = "/product/{productId}/user/{userId}")
    public Bill getBill(@PathVariable String productId, @PathVariable String userId){
        return billingServices.getBill(productId, userId);
    }
    
    @GetMapping(value = "/product/{productId}")
    public List<Bill> getBills(@PathVariable String productId){
    	return billingServices.bills(productId);
    }
    
    @GetMapping("/")
    public List<Bill> getAll(){
    	return billingServices.allBills();
    }

    @PostMapping(value = "/")
    public Bill createBill(@RequestBody Bill bill){
        return billingServices.postBill(bill);
    }

    @PutMapping(value = "/product/{productId}/user/{userId}")
    public Bill updateBill(@PathVariable String productId, @PathVariable String userId, @RequestBody Bill bill){
        return billingServices.updateBill(productId, userId, bill);
    }
    
    @DeleteMapping("/")
    public void deleteAll() {
    	billingServices.deleteAll();
    }

}
