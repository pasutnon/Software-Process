package com.sit.swprocess.DogeCommerce.OrderDetail;

import com.sit.swprocess.DogeCommerce.Order.Order;
import com.sit.swprocess.DogeCommerce.Product.Product;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    Product product;

    @NotNull
    int quantity;

    @NotNull
    double priceEach;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    Order order;

    public OrderDetail() {
    }

    public OrderDetail(@NotNull Product product, @NotNull int quantity, @NotNull double priceEach) {
        this.product = product;
        this.quantity = quantity;
        this.priceEach = priceEach;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }
}
