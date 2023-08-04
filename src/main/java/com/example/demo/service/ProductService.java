package com.example.demo.service;

import com.example.demo.Role;
import com.example.demo.model.Product;
import com.example.demo.model.User;
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

    public void oneProduct(Product product){
        productRepo.findById(product.getProductId());
    }

    public void deleteProduct(int id){
        productRepo.deleteById(id);
    }


    public void product(){
        Product prd = new Product();
        prd.setTitle("tv");
        prd.setPrice(5000);
        prd.setDate(null);
        prd.setDescription("product description");
        prd.setQuantity("2");
        productRepo.save(prd);
    }

}
