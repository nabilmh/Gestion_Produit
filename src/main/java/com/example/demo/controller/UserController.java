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
    @PostConstruct
    public void user(){
        userService.user();
    }
    @GetMapping("/user/{userid}")
    public List<Product> getAllProduct(){
        return productSer.getAllProduct();
    }

    @PostMapping("/user/{userId}/addnewproduct")
    User addNewProduct(@PathVariable int userId, @PathVariable int productId){
        Product product = productRepo.findById(productId).get();
        User user = userRepo.findById(userId).get();
        user.addnewProduct(product);
        productSer.addNewProduct(product);
        return userRepo.save(user);
    }

}
