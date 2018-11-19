package com.sit.swprocess.DogeCommerce.Address;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AddressController{

    @Autowired
    AddressService addressService;

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAddressAll() {
        return new ResponseEntity<List<Address>>(addressService.getAddressAll(), HttpStatus.OK);
    }

    @GetMapping("/address/{address_id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long address_id) {
        return new ResponseEntity<Address>(addressService.getAddressById(address_id).get(), HttpStatus.OK);
    }
}