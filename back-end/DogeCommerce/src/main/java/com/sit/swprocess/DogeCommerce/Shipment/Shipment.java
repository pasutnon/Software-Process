package com.sit.swprocess.DogeCommerce.Shipment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sit.swprocess.DogeCommerce.Address.Address;
import com.sit.swprocess.DogeCommerce.Address.ShipmentAddress;

import java.io.Serializable;

@Entity
@Table(name = "shipments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Shipment implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Double price;

    @NotBlank
    private String trackingNumber;

    @OneToOne
    private ShipmentAddress address;

    public Shipment() {
    }

    public Shipment(Long id, Double price, String trackingNumber, ShipmentAddress address) {
        this.id = id;
        this.price = price;
        this.trackingNumber = trackingNumber;
        this.address = address;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String getTrackingNumber() {
        return this.trackingNumber;
    }
    
    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
    
    public ShipmentAddress getShipmentAddress() {
        return this.address;
    }
    
    public void setAddress(ShipmentAddress address) {
        this.address = address;
    }
}