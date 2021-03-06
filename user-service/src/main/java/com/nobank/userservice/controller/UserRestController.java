package com.nobank.userservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nobank.userservice.model.User;
import com.nobank.userservice.service.UserServices;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/users")
public class UserRestController {

    @Autowired
    private UserServices userServices;

    @PostMapping()
    public User createUser(@RequestBody User user){

        return userServices.createUser(user);
    }

    @GetMapping()
    public List<User> getUsers(){
        return userServices.getUsers();
    }

    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable String userId, @RequestHeader Map<String , String> header){
        //TODO: check user Exists or not

        return userServices.getUser(userId);
    }

    @PutMapping(value = "/{email}")
    public User updateUser(@PathVariable String email, @RequestBody User user){
        //TODO: check User exists or not

        return userServices.updateUser(email, user);
    }

    @DeleteMapping(value = "/{userId}")
    public User deleteUser(@PathVariable String userId){

        //TODO: check user exists or not

        return userServices.deleteUser(userId);
    }

}
