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

    @PostMapping("/products")
    public Product  addProduct(@RequestBody Product product){

        return productSer.addNewProduct(product);
    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){

        return productSer.getAllProduct();
    }

    @GetMapping("/products/{productId}")
    public Product oneProduct(@PathVariable("productId") int productId){
        Product product = productRepo.findById(productId).get();
        return product;
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId){
        productSer.deleteProduct(productId);
    }
}
