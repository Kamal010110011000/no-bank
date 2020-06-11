package com.nobank.userservice.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nobank.userservice.model.Account;
import com.nobank.userservice.model.Bill;
import com.nobank.userservice.model.History;
import com.nobank.userservice.model.History.TransferType;
import com.nobank.userservice.model.Product;
import com.nobank.userservice.model.Quantity;
import com.nobank.userservice.model.User;
import com.nobank.userservice.service.ProductServices;
import com.nobank.userservice.service.UserServices;

@Controller
public class ShopController {
	
	@Autowired
	private ProductServices productServices;
	
	@Autowired
	private UserServices userServices;
	
	@GetMapping("/shop")
    public String viewShop(Model model, Principal principal) {
    	
    	String user = principal.getName();
    	
    	List<Product> products =productServices.getProducts();
    	Map<String, Object> map = new HashMap<>();
    	
    	map.put("name", userServices.getUserByEmail(user).getName());
    	map.put("products", products);
    	map.put("len", products.size());
    	map.put("MODE", "shop");
    	model.addAllAttributes(map);
    	return "shop";
    } 

    
    
    @PostMapping("/shop/buy")
    public String buyProd(@ModelAttribute("productId") String productId, 
    		@ModelAttribute("userId") String userId, @ModelAttribute("quantity") int quantity,
    		Model model, Principal principal) {
    	String username = principal.getName();
    	User user =userServices.getUserByEmail(username);
    	Quantity q = new Quantity(user.getId(),userId,quantity);
    	
    	Product product = productServices.getProduct(productId);
    	List<Bill> bills = productServices.getBill(productId);
    	Map<String, Object> map = new HashMap<>();
    	
    	map.put("name", user.getName());
    	map.put("product", product);
    	map.put("MODE" , "shop");
    	map.put("bills", bills);
    	map.put("size", bills.size());
    	map.put("success", "order placed successfully");
    	
    	try {
    		List<String> products = user.getProducts();
    		if(!products.contains(productId)) {
    			products.add(productId);
    			user.setProducts(products);
    		}
    		productServices.updateProduct(productId, userId, q);
    		List<String> prods = user.getProducts();
    		prods.add(productId);
    		user.setProducts(prods);
    		LinkedList<History> history = user.getHistory();
    		history.addFirst(new History(LocalDateTime.now(), 5000, product.getName(), TransferType.Invest));
    		user.setHistory(history);
    		Account account = user.getAccount();
    		double balance = account.getBalance()-5000;
    		account.setBalance(balance);
    		user.setAccount(account);
    		userServices.updateUser(username, user);
    		
    	}
    	catch(Exception ex) {
    		ex.printStackTrace();
    		map.put("success", "something went wrong");
    	}
    	model.addAllAttributes(map);
    	
    	
    	return "shop-item";
    }

    @GetMapping("/shop/{productId}")
    public String getProduct(@PathVariable String productId, Model model, Principal principal){
    	String username = principal.getName();
    	
    	Product product = productServices.getProduct(productId);
    	List<Bill> bills = productServices.getBill(productId);
    	Map<String, Object> map = new HashMap<>();
    	
    	map.put("name", userServices.getUserByEmail(username).getName());
    	map.put("product", product);
    	map.put("MODE" , "shop");
    	map.put("bills", bills);
    	map.put("size", bills.size());
    	model.addAllAttributes(map);

        return "shop-item";
    }
    
}
