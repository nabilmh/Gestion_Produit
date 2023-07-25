package com.example.demo.controller;

import com.example.demo.model.Agence;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.AgenceRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productSer;
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AgenceRepository agenceRepo;
    @Autowired
    private ProductRepository productRepo;

    @PostMapping("/user/addnewproduct")
    public Product addNewProduct(@RequestBody Product product){
        return productSer.addNewProduct(product);
    }

    @PostMapping("/user/{userId}/addnewproduct")
    public Product  addNewProduct(@PathVariable("userId") int userId,@RequestBody Product product){
        User user = userRepo.findById(userId).get();

        product.setUser(user);
        System.out.println(user.getUserId());
        return productSer.addNewProduct(product);
    }
    @GetMapping("/user/{userId}/allproducts")
    public List<Product> getAllProduct(){
        return productSer.getAllProduct();
    }

    @DeleteMapping("/deleteproduct/{id}")
    public void deleteProduct(@PathVariable("id") int productId){
        productSer.deleteProduct(productId);
    }
}
