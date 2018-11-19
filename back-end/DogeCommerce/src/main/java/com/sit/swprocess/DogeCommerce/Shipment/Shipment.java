package com.sit.swprocess.DogeCommerce.Shipment;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sit.swprocess.DogeCommerce.Address.ShipmentAddress;
import org.springframework.lang.Nullable;

import java.io.Serializable;

@Entity
@Table(name = "shipments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Shipment implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double price;

    @Nullable
    private String trackingNumber;

    @OneToOne
    private ShipmentAddress address;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ShipmentMethod shipmentMethod;

    public Shipment() {
    }

    public Shipment(@NotNull Double price, @NotNull String trackingNumber, ShipmentAddress address, ShipmentMethod shipmentMethod) {
        this.price = price;
        this.trackingNumber = trackingNumber;
        this.address = address;
        this.shipmentMethod = shipmentMethod;
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