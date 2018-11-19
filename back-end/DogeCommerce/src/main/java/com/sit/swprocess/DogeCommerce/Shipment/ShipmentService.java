package com.sit.swprocess.DogeCommerce.Shipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {

    @Autowired
    ShipmentRepository shipmentRepository;

    public Shipment getShipmentById(Long shipmentId) {
        return shipmentRepository.getOne(shipmentId);
    }
}
