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
import com.sit.swprocess.DogeCommerce.Address.Address;

@Entity
@Table(name = "shipments")
public class Shipment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Double price;

    @NotBlank
    private String trackingNumber;

    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    @JsonIgnore
    private Address address;

    public Shipment() {
    }

    public Shipment(Long id, Double price, String trackingNumber, Address address) {
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
    
    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", price='" + getPrice() + "'" +
            ", trackingNumber='" + getTrackingNumber() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }
}