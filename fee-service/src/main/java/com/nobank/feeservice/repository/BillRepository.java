package com.nobank.feeservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nobank.feeservice.model.Bill;

public interface BillRepository extends MongoRepository<Bill, String> {
    Bill findByProductIdAndUserId(String productId, String userId);
    List<Bill> findByProductIdAndStatus(String productId,boolean status);
}
