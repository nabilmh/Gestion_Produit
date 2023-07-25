package com.example.demo.service;

import com.example.demo.model.Agence;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.AgenceRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceService {
    @Autowired
    private AgenceRepository agenceRepo;

    public Agence addNewAgence(Agence agence){
        return agenceRepo.save(agence);
    }

    public List<Agence> getAllAgence(){
        return (List<Agence>) agenceRepo.findAll();
    }

    public void deleteAgence(int agneceId){
        agenceRepo.deleteById(agneceId);
    }

    public void agence(){
        Agence agence = new Agence();

        agence.setTitle("agence1");
        agence.setAddress("Massira 2");

        agenceRepo.save(agence);
    }
}
