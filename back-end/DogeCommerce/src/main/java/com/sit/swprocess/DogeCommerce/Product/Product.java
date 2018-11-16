package com.sit.swprocess.DogeCommerce.Product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Table(name="product")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @NotBlank
    private String skuNumber;

    @NotBlank
    private String productName;

    @NotBlank
    private double price;

    @NotBlank
    private String productDetail;

    @NotBlank
    private int stockQuantity;

    // private User user;
    
    public Product() {
    }
    
    public Product(long id, String skuNumber, String productName, double price, String productDetail,
            int stockQuantity) {
        this.id = id;
        this.skuNumber = skuNumber;
        this.productName = productName;
        this.price = price;
        this.productDetail = productDetail;
        this.stockQuantity = stockQuantity;
    }
    
    public long getProductId() {
        return this.id;
    }
    
    public void setProductId(long id) {
        this.id = id;
    }
    public String getSkuNumber() {
        return this.skuNumber;
    }
    
    public void setSkuNumber(String skuNumber) {
        this.skuNumber = skuNumber;
    }
    
    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getProductDetail() {
        return this.productDetail;
    }
    
    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }
    
    public int getStockQuantity() {
        return this.stockQuantity;
    }
    
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    
    @Override
    public String toString() {
        return "{" +
            " productId='" + getProductId() + "'" +
            ", skuNumber='" + getSkuNumber() + "'" +
            ", productName='" + getProductName() + "'" +
            ", price='" + getPrice() + "'" +
            ", productDetail='" + getProductDetail() + "'" +
            ", stockQuantity='" + getStockQuantity() + "'" +
            "}";
    }
    
}
