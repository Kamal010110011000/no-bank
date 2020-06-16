package com.nobank.userservice.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nobank.userservice.model.Account;
import com.nobank.userservice.model.Address;
import com.nobank.userservice.model.History;
import com.nobank.userservice.model.Product;
import com.nobank.userservice.model.User;
import com.nobank.userservice.service.ProductServices;

@Service
public class DBinit implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProductServices productServices;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        List<Product> p = new LinkedList<>();
        List<String> fs = new ArrayList<>();
        LinkedList<History> h =new LinkedList<>(); 

        List<String> roles = new ArrayList<>();
        roles.add("user");
        User user = new User("Kamal",
                "kamal@gmail.com",
                p,
                fs,
                Long.parseLong("123456789098"),
                Long.parseLong("9876567656"),
                new Address("premnager", "Dehradun", 248001, "India"),
                "image",
                new BCryptPasswordEncoder().encode("password"),
                new Account(Account.Type.Saving, 20000.00),
                h,
                roles,
                fs);
        userRepository.save(user);
        User user1 = new User("Harsh",
                "harsh@gmail.com",
                p, fs,
                Long.parseLong("123450000098"),
                Long.parseLong("9800067656"),
                new Address("premnager","Dehradun",248001, "India"),
                "image",
                new BCryptPasswordEncoder().encode("password"),
                new Account(Account.Type.Saving, 20000.00),
                h,
                roles,
                fs);
        userRepository.save(user1);
        User user2 = new User("Akash",
                "akash.@gmail.com",
                p, fs, Long.parseLong("123411119098"),
                Long.parseLong("9876111656"),
                new Address("premnager","Dehradun",248001, "India"),
                "image",
                new BCryptPasswordEncoder().encode("password"),
                new Account(Account.Type.Saving,20000.00),
                h,
                roles,
                fs);
        userRepository.save(user2);

        User user3 = userRepository.findByEmail("kamal@gmail.com");
          
        LocalDateTime now = LocalDateTime.now();
        
        History h1 = new History( now, 2000.00, "akash@gmail.com", History.TransferType.Credit );
        h.add(h1);
        h1 = new History( now, 2000.00, "harsh@gmail.com", History.TransferType.Debit );
        h.add(h1);
        h1 = new History( now, 1000.00, "harsh@gmail.com", History.TransferType.Credit );
        h.add(h1);
        h1 = new History( now, 2000.00, "akash@gmail.com", History.TransferType.Debit );
        h.add(h1);
        h1 = new History( now, 2000.00, "akash@gmail.com", History.TransferType.Credit );
        h.add(h1);
        h1 = new History( now, 3000.00, "harsh@gmail.com", History.TransferType.Debit );
        h.add(h1);
        h1 = new History( now, 2000.00, "harsh@gmail.com", History.TransferType.Debit );
        h.add(h1);
        h1 = new History( now, 4000.00, "akash@gmail.com", History.TransferType.Credit );
        h.add(h1);
        h1 = new History( now, 5000.00, "harsh@gmail.com", History.TransferType.Credit );
        h.add(h1);
        h1 = new History( now, 6000.00, "harsh@gmail.com", History.TransferType.Debit );
        h.add(h1);
        
        user3.setHistory(h);
        userRepository.save(user3);
        

        
        System.out.println(user2.toString());
        System.out.println(user1.toString());
        System.out.println(user3.toString());
        
    }
}
