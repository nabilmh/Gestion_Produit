package com.example.demo.service;

import com.example.demo.model.Agence;
import com.example.demo.repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenceService {
    @Autowired
    private AgenceRepository agenceRepo;
    public Agence addnewagence(Agence agence){
        return agenceRepo.save(agence);
    }
}
