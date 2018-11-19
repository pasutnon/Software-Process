package com.sit.swprocess.DogeCommerce.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentAddressService {
    @Autowired
    ShipmentAddressRepository shipmentAddressRepository;

    public ShipmentAddress saveShipmentAddress(ShipmentAddress shipmentAddress) {
        return shipmentAddressRepository.save(shipmentAddress);
    }
}
