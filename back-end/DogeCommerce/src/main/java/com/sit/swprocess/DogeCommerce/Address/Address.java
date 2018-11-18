package com.sit.swprocess.DogeCommerce.Address;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String name;

    @NotNull
    String address;

    @NotNull
    String district;

    @NotNull
    String state;

    @NotNull
    String province;

    @NotNull
    String postcode;

    public Address() {
    }

    public Address(@NotNull String name, @NotNull String address, @NotNull String district, @NotNull String state, @NotNull String province, @NotNull String postcode) {
        this.name = name;
        this.address = address;
        this.district = district;
        this.state = state;
        this.province = province;
        this.postcode = postcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
