package com.sit.swprocess.DogeCommerce.ProductImage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductImageService {

    @Autowired
    ProductImageRepository productImageRepository;

    public ProductImage getPathByProductId(Long product_id) {
        return productImageRepository.findPathByProductId(product_id);
    }

}