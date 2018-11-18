package com.sit.swprocess.DogeCommerce.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.getOneByEmail(email);
    }
}
