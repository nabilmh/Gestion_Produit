package com.example.demo.controller;

import com.example.demo.model.Agence;
import com.example.demo.service.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgenceController {
    @Autowired
    private AgenceService agenceSer;
    public Agence addnewagence(@RequestBody Agence agence){
        return agenceSer.addnewagence(agence);
    }
}
