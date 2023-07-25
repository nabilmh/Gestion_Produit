package com.example.demo.service;

import com.example.demo.model.Agence;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;

import java.util.List;

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

    public User addNewUser(User user){
        return userRepo.save(user);
    }

    public List<User> getAllUser(){
        return (List<User>) userRepo.findAll();
    }

    public void deleteUser(int userId){
        userRepo.deleteById(userId);
    }

}
