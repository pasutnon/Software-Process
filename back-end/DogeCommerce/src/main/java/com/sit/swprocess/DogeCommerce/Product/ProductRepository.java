package com.sit.swprocess.DogeCommerce.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
     List<Product> findByProductName(String productName);
     List<Product> findByProductNameContaining(String productName);


}