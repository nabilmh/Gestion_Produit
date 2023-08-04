package com.example.demo.service;

import com.example.demo.Role;
import com.example.demo.model.Agence;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepo;
    public void user(){
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRole(Role.SuperUser);
        userRepo.save(admin);

        User admin2 = new User();
        admin2.setUsername("admin2");
        admin2.setPassword(passwordEncoder.encode("admin2"));
        admin2.setRole(Role.User);
        userRepo.save(admin2);
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
