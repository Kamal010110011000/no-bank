package com.nobank.feeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nobank.feeservice.model.Bill;
import com.nobank.feeservice.repository.BillRepository;

@Service
public class BillingServices {

    @Autowired
    private BillRepository billRepository;

    public Bill getBill(String productId, String userId){

        return billRepository.findByProductIdAndUserId(productId, userId);

    }
    
    public List<Bill> allBills(){
    	return billRepository.findAll();
    }
    
    public List<Bill> bills(String productId){
    	return billRepository.findByProductIdAndStatus(productId,true);
    }

    public Bill postBill(Bill bill){
        return billRepository.save(bill);
    }

    public Bill updateBill(String productId, String userId, Bill newBill){
        Bill bill = billRepository.findByProductIdAndUserId(productId, userId);

        bill.setDividend(newBill.getDividend());
        bill.setFace_value(newBill.getFace_value());
        bill.setMarket_value(newBill.getMarket_value());

        return billRepository.save(bill);
    }
    
    public void deleteAll() {
    	billRepository.deleteAll();
    }
}
