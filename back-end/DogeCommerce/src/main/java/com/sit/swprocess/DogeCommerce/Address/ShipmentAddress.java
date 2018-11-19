package com.sit.swprocess.DogeCommerce.Address;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value="true")
public class ShipmentAddress extends Address {

    public ShipmentAddress() {
    }

    public ShipmentAddress(@NotNull String name, @NotNull String address, @NotNull String district, @NotNull String state, @NotNull String province, @NotNull String postcode) {
        super(name, address, district, state, province, postcode);
    }
}
