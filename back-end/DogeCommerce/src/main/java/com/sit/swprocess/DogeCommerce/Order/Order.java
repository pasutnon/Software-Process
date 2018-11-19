package com.sit.swprocess.DogeCommerce.Order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sit.swprocess.DogeCommerce.OrderDetail.OrderDetail;
import com.sit.swprocess.DogeCommerce.Payment.Payment;
import com.sit.swprocess.DogeCommerce.Shipment.Shipment;
import com.sit.swprocess.DogeCommerce.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order implements Serializable {

    @Autowired
    DecimalFormat decimalFormat;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "order")
    List<OrderDetail> orderDetails;

    @Nullable
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    Payment payment;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id")
    Shipment shipment;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    User buyer;

    @NotNull
    String status;

    public Order() {
    }

    public Order(List<OrderDetail> orderDetails, @NotNull Payment payment, @NotNull Shipment shipment, @NotNull User buyer, @NotNull String status) {
        this.orderDetails = orderDetails;
        this.payment = payment;
        this.shipment = shipment;
        this.buyer = buyer;
        this.status = status;
    }

    public DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }

    public void setDecimalFormat(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public long calculatePriceForOmise() {
        long price = 0;
        if (orderDetails != null) {
            for(OrderDetail orderDetail: this.orderDetails) {
                price +=  Long.parseLong(decimalFormat.format(orderDetail.getQuantity() * orderDetail.getPriceEach()));
            }
        }
        return price + 3000;
    }

    @Override
    public String toString() {
        return "Order{" +
                "decimalFormat=" + decimalFormat +
                ", id=" + id +
                ", orderDetails=" + orderDetails +
                ", payment=" + payment +
                ", shipment=" + shipment +
                ", buyer=" + buyer +
                ", status='" + status + '\'' +
                '}';
    }
}
