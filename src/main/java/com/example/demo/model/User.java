package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Column(name = "ID")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Product> products = new HashSet<>();

    public User() {

    }
    public User(int userId, String username, String password) {
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;

    }
    public int getId() {
        return userId;
    }

    public void setId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Product> getProducts() {
        return products;
    }
    public void addnewProduct(Product product){
        products.add(product);
    }

}