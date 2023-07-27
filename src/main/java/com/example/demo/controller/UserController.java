package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/")
    public List<Product> onlyforvisitor(){
        return productSer.getAllProduct();
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
