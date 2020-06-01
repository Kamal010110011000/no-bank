package com.nobank.productservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nobank.productservice.model.Bill;
import com.nobank.productservice.model.Product;
import com.nobank.productservice.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private BillServices billService;

    public void createProduct(Product product, Bill bill){

        Product prod = productRepository.save(product);
        bill.setProductId(prod.getId());
        billService.postBill(bill);
    }

    public List<Product> getProducts(){
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    public List<Product> getProductsWithName(String name){
        List<Product> productList = productRepository.findByNameContaining(name);
        return productList;
    }

    public Product getProduct(String productId){
        Optional<Product> product = productRepository.findById(productId);
        return product.get();
    }

    public Map<String, Object> deleteProduct(String productId){
        Optional<Product> product = productRepository.findById(productId);
        productRepository.delete(product.get());

        Map<String ,Object> map = new HashMap<>();
        map.put("message", "deleted successfully");
        map.put("data", product);

        return map;
    }

    public Map<String, Object> updateProduct(String productId, int quantity){
        Optional<Product> optionalProduct = productRepository.findById(productId);
        Product updatedProduct = optionalProduct.get();
        updatedProduct.setAvailable(updatedProduct.getAvailable()-quantity);

        productRepository.save(updatedProduct);

        Map<String , Object> map = new HashMap<>();
        map.put("message", "Product details updated!");
        map.put("product", updatedProduct);

        return map;
    }
    
    public void deleteAll() {
    	productRepository.deleteAll();
    	billService.deleteAll();
    }
}
