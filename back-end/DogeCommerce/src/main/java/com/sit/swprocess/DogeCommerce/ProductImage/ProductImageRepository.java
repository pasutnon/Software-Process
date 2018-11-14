package com.sit.swprocess.DogeCommerce.ProductImage;

import java.util.List;

import com.sit.swprocess.DogeCommerce.Product.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    public List<ProductImage> getProductImageByProduct(Product product);
}