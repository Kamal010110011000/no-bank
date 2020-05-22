package com.nobank.feeservice.controller;

import com.nobank.feeservice.model.Bill;
import com.nobank.feeservice.service.BillingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/fee")
public class BillController {

    @Autowired
    private BillingServices billingServices;


    @GetMapping(value = "/product/{productId}/user/{userId}")
    public Bill getBill(@PathVariable String productId, @PathVariable String userId){
        return billingServices.getBill(productId, userId);
    }

    @PostMapping(value = "/")
    public Bill createBill(@RequestBody Bill bill){
        return billingServices.postBill(bill);
    }

    @PutMapping(value = "/product/{productId}/user/{userId}")
    public Bill updateBill(@PathVariable String productId, @PathVariable String userId, @RequestBody Bill bill){
        return billingServices.updateBill(productId, userId, bill);
    }

}
