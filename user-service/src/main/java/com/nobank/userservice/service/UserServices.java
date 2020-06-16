package com.nobank.userservice.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nobank.userservice.model.History;
import com.nobank.userservice.model.Product;
import com.nobank.userservice.model.User;
import com.nobank.userservice.repository.UserRepository;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
    	ArrayList<String> role = new ArrayList<String>();
    	role.add("user");
    	user.setHistory(new LinkedList<History>());
    	user.setForSale(new ArrayList<String>());
    	user.setProducts(new LinkedList<Product>());
    	user.setRoles(role);
    	user.setPermissions(new ArrayList<>());
    	
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public User getUser(String id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User updateUser(String email, User user){
        User userdata = userRepository.findByEmail(email);

        userdata.setAadhar_no(user.getAadhar_no());
        userdata.setEmail(user.getEmail());
        userdata.setPhone(user.getPhone());
        userdata.setProducts(user.getProducts());
        userdata.setForSale(user.getForSale());
        userdata.setHistory(user.getHistory());
        userdata.setAccount(user.getAccount());
        userRepository.save(userdata);

        return userdata;
    }

    public User deleteUser(String id){
        Optional<User> user = userRepository.findById(id);
        userRepository.delete(user.get());

        return user.get();
    }

    public User getUserByEmail(String email){
        User user = userRepository.findByEmail(email);
        return user;
    }

    public List<History> getNewTranscation(String email){

        User user = userRepository.findByEmail(email);

        List<History> history = user.getHistory();
        List<History> newTransiction = new ArrayList<>();
            for (History h : history) {
                if (!h.isStatus()) {
                    newTransiction.add(h);
                }
            }
        return newTransiction;
    }

    public List<History> getHistory(String email){
        
        User user = userRepository.findByEmail(email);
        
        List<History> history = user.getHistory();
        
        return history;
    }

}
