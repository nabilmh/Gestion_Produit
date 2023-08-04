package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="agence")
public class Agence {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int agenceId;

    private String title;
    private String Address;

    @OneToOne
    @JoinColumn
    private User user;

    public int getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(int agenceId) {
        this.agenceId = agenceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }


}
