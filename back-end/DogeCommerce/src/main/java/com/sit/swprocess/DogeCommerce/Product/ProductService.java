package com.sit.swprocess.DogeCommerce.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService{

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public List<Product> getAllProductByName(String productName){
        return productRepository.findByProductName(productName);
    }
}