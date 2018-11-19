package com.sit.swprocess.DogeCommerce.Shipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentMethodService {
    @Autowired
    ShipmentMethodRepository shipmentMethodRepository;

    public ShipmentMethod getShipmentMethodByShipmentMethodId(Long shipmentMethodId) {
        return shipmentMethodRepository.getOne(shipmentMethodId);
    }

    public List<ShipmentMethod> getAllShipmentMethods() {
        return shipmentMethodRepository.findAll();
    }
}
