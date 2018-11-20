package com.sit.swprocess.DogeCommerce.Address;

import java.util.List;
import java.util.Optional;

import com.sit.swprocess.DogeCommerce.User.User;
import com.sit.swprocess.DogeCommerce.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
@CrossOrigin
public class AddressController{

    @Autowired
    AddressService addressService;

    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<List<Address>> getAddressAll() {
        return new ResponseEntity<List<Address>>(addressService.getAddressAll(), HttpStatus.OK);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long addressId) {
        return new ResponseEntity<Address>(addressService.getAddressById(addressId).get(), HttpStatus.OK);
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Address> createAddressByUserId(@RequestBody Address address, @PathVariable Long userId) {
        Address newAddress = addressService.createAddressByUserId(userId, address);
        return new ResponseEntity<>(newAddress, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Address>> getAddressesByUserId(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        List<Address> addresses = user.get().getAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }
}