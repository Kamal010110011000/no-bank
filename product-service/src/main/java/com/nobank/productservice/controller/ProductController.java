package com.nobank.productservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nobank.productservice.model.Bill;
import com.nobank.productservice.model.Data;
import com.nobank.productservice.model.Holder;
import com.nobank.productservice.model.Product;
import com.nobank.productservice.model.Quantity;
import com.nobank.productservice.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping(value = "/")
    public void createProduct(@RequestBody Data data, @RequestHeader Map<String , String> header){

        Bill bill = data.getBill();
        Product prod = data.getProduct();
        productService.createProduct(prod,bill);

    }

    @GetMapping(value = "/")
    public List<Product> getProducts( @RequestHeader Map<String , String> header){
        List<Product> products =  productService.getProducts();
        //TODO: check if products list is empty or not

        return products;
    }

    @GetMapping(value = "/{productId}")
    public Product getProduct(@PathVariable String productId, @RequestHeader Map<String , String> header){

        //TODO: check is product exists or not
        Product product = productService.getProduct(productId);

        return product;
    }

    @GetMapping(value = "/search/{name}")
    public List<Product> getProductByName(@PathVariable String name,  @RequestHeader Map<String , String> header){

        List<Product> products = productService.getProductsWithName(name);

        //TODO: check if list is empty or not

        return products;
    }

    @PutMapping(value = "/{productId}")
    public boolean updateProduct(@PathVariable String productId, @RequestBody Quantity quantity){
        //TODO: check if product exists or not
    	Holder holder = new Holder(quantity.getUser1Id(), quantity.getQuantity());
        Map<String, Object> map = productService.updateProduct(productId, quantity.getQuantity(), holder);

        return true;
    }

    @DeleteMapping(value = "/{productId}")
    public Map<String, Object> deleteProduct(@PathVariable String productId){
        //TODO: check if product exists or not

        return productService.deleteProduct(productId);
    }

    @GetMapping(value = "/{productId}/from/{holder}/quantity/{quantity}")
    public Product getProduct(@PathVariable String productId, @PathVariable String holder, @PathVariable int quantity){
        Product product = productService.getProduct(productId);
        List<Holder> holder1 = product.getHolders();
        Holder holder2=new Holder();
        for(Holder h: holder1){
            if(h.getHolder().matches(holder)){
                holder2 = h;
                break;
            }
        }
        if(holder2.getQuantity()<quantity){
            return null;
        }
        return product;

    }

}
