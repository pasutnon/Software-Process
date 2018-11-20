package com.sit.swprocess.DogeCommerce.User;

import com.sit.swprocess.DogeCommerce.Address.Address;
import com.sit.swprocess.DogeCommerce.AuthenProvider.AuthenProvider;
import com.sit.swprocess.DogeCommerce.AuthenProvider.AuthenProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenProviderService authenProviderService;

    @Autowired
    JwtService jwtService;

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

    public String signInWithFacebook(String facebookToken, String firstname, String lastname, String email) {
        Optional<User> userFromEmail = this.getUserByEmail(email);
        if(userFromEmail.isPresent() == false) {
            User newUser = this.createNewUserFromFacebook(facebookToken, firstname, lastname, email);
            String token = jwtService.encodeUser(newUser);
            String jsonSession = "{\"token\": \""+ token +"\",\"userId\":"+ newUser.getId() +"}";
            return jsonSession;
        }else {
            User user = this.getUserByFacebookToken(facebookToken);
            if( user != null) {
                String token = jwtService.encodeUser(user);
                String jsonSession = "{\"token\": \""+ token +"\",\"userId\":"+ user.getId() +"}";
                return jsonSession;
            }
        }
        return null;
    }

    private User createNewUserFromFacebook(String facebookToken, String firstname, String lastname, String email) {
        AuthenProvider authenProvider = new AuthenProvider("Facebook", facebookToken);
        List<AuthenProvider> authenProviderList = new ArrayList<>();
        authenProviderList.add(authenProvider);
        User user = new User(
                null,
                firstname,
                null,
                email,
                firstname,
                lastname,
                null,
                authenProviderList
        );
        return this.saveUser(user);
    }

}
