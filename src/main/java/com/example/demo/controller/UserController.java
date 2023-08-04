package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {



    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productSer;

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ProductRepository productRepo;

    private Product product;
    @PostConstruct
    public void user(){
        userService.user();
    }


    @GetMapping("/users")
    @ResponseStatus(value = HttpStatus.OK)
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }


    @PostMapping("/user")
    public User createUser( @RequestBody User user) {
        return userRepo.save(user);
    }

    @GetMapping("/users/{userId}")
    public User getoneUser(@PathVariable("userId") int userId){
        User user = userRepo.findById(userId).get();
        return user;
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") int userId){
        User user = userRepo.findById(userId).get();
        userService.deleteUser(userId);
    }



}
