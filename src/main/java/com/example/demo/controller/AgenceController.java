package com.example.demo.controller;

import com.example.demo.model.Agence;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.AgenceRepository;
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

    private AgenceRepository agenceRepo;

    @PostConstruct
    public void agence(){
        agenceSer.agence();
    }

    @PostMapping("/agencies")
    public Agence  addAgence(@RequestBody Agence agence){
        return agenceSer.addNewAgence(agence);
    }
    @GetMapping("/agencies")
    public List<Agence> getAllAgences(){

        return agenceSer.getAllAgence();
    }

    @GetMapping("/agencies/{agenceId}")
    public Agence oneAgence(@PathVariable("agenceId") int agenceId){
        Agence agence = agenceRepo.findById(agenceId).get();
        return agence;
    }

    @DeleteMapping("/agencies/{agenceId}")
    public void deleteAgence(@PathVariable("agenceId") int agenceId){
        Agence agence = agenceRepo.findById(agenceId).get();
        agenceSer.deleteAgence(agenceId);
    }

}
