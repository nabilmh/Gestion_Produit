package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;
    public Product addNewProduct(Product product){
        return productRepo.save(product);
    }

    public List<Product> getAllProduct(){
        return (List<Product>) productRepo.findAll();
    }

    public void deleteProduct(int id){
        productRepo.deleteById(id);
    }
}
