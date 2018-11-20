package com.sit.swprocess.DogeCommerce.Address;


import com.sit.swprocess.DogeCommerce.User.User;
import com.sit.swprocess.DogeCommerce.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserService userService;

    public List<Address> getAddressAll() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Long addressId) {
        return addressRepository.findById(addressId);
    }

    public Address createAddressByUserId(Long userId, Address address) {
        User user = userService.getUserById(userId).get();
        List<Address> addresses = user.getAddresses();
        addresses.add(address);
        User modifiedUser = userService.saveUser(user);
        List<Address> modifiedUserAddresses = modifiedUser.getAddresses();
        return modifiedUserAddresses.get(modifiedUserAddresses.size()-1);
    }
}