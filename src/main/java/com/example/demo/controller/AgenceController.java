package com.example.demo.controller;

import com.example.demo.model.Agence;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AgenceService;
import com.example.demo.service.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgenceController {
    @Autowired
    private AgenceService agenceSer;

    @Autowired
    private ProductService productSer;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ProductRepository productRepo;

    @PostConstruct
    public void agence(){
        agenceSer.agence();
    }

    @GetMapping("/user/{userId}/agence")
    public List<Agence> agences(){
        return agenceSer.getAllAgence();
    }
}
