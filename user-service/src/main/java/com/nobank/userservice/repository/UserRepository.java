package com.nobank.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nobank.userservice.model.User;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);
    
    User findByAccount_AcNo(long ac_no);


}
