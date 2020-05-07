package com.nobank.productservice.repository;

import com.nobank.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByNameContaining(String name);
}
