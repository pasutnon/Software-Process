package com.sit.swprocess.DogeCommerce.Product;

import java.util.List;

import com.sit.swprocess.DogeCommerce.ProductImage.ProductImage;
import com.sit.swprocess.DogeCommerce.ProductImage.ProductImageService;
import com.sit.swprocess.DogeCommerce.Product.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImageService productImageService;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long product_id) {
        return productRepository.findById(product_id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", product_id));

    }

    public List<Product> getAllProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    public ProductImage getPathByProductId(Long product_id) {

        return productImageService.getPathByProductId(product_id);

    }

}