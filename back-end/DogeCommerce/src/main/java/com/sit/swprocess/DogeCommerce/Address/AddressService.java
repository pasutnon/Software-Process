package com.sit.swprocess.DogeCommerce.Address;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAddressAll() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Long address_id) {
        return addressRepository.findById(address_id);
    }

}