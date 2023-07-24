package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    public void user(){
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        userRepo.save(admin);
    }

}
