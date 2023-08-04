package com.example.demo.controller;

import com.example.demo.model.Agence;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.AgenceRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productSer;
    @Autowired
    private UserRepository userRepo;

    private int userId;
    @Autowired
    private AgenceRepository agenceRepo;
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private UserService userServ;

    @PostMapping("/")
    public Product addNewProduct(@RequestBody Product product){
        return productSer.addNewProduct(product);
    }

    @PostMapping("/products")

    public Product  addProduct(@RequestBody Product product){

// TODO:GET USER FROM AUTH AND ANGENCIES FROM USER
        return productSer.addNewProduct(product);
    }
    @GetMapping("/products")
    @ResponseStatus(value = HttpStatus.OK)
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

    @PostConstruct
    public void product(){
        productSer.product();
    }
}
