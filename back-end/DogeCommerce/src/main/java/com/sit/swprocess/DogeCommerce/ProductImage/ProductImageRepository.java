package com.sit.swprocess.DogeCommerce.ProductImage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    ProductImage findPathByProductId(Long product_id);
}