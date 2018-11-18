package com.sit.swprocess.DogeCommerce.Product;

import java.util.List;

import com.sit.swprocess.DogeCommerce.ProductImage.ProductImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> product = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
    }

    @RequestMapping(path = "/products/name/{name}")
    public ResponseEntity<List<Product>> getAllProductsByName(@PathVariable("name") String name) {

        List<Product> product = productService.getAllProductByName(name);
        return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
    }

    @RequestMapping(path = "/products/{product_id}/images")
    public ResponseEntity<ProductImage> getPathByProductId(@PathVariable("product_id") Long product_id) {
        ProductImage product_image = productService.getPathByProductId(product_id);
        return new ResponseEntity<ProductImage>(product_image, HttpStatus.OK);
    }

    @RequestMapping(path = "/products/{product_id}/id")
    public ResponseEntity<Product> getProductById(@PathVariable("product_id") Long product_id) {
        Product product = productService.getProductById(product_id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);

    }

}