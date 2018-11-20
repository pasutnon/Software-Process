package com.sit.swprocess.DogeCommerce.User;

import com.sit.swprocess.DogeCommerce.Address.Address;
import com.sit.swprocess.DogeCommerce.AuthenProvider.AuthenProvider;
import com.sit.swprocess.DogeCommerce.AuthenProvider.AuthenProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenProviderService authenProviderService;

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.getOneByEmail(email);
    }

    public User getByEmailOrUsername(String email, String username) {
        return userRepository.getByEmailOrUsername(email, username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByFacebookToken(String token) {
        AuthenProvider authenProvider = authenProviderService.getAuthenProviderByToken(token);
        if(authenProvider == null) {
            return null;
        }
        User user = userRepository.getByAuthenProviders(authenProvider);
        return user;
    }

}
