package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="agence")
public class Agence {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String products;
    private String Address;
}
