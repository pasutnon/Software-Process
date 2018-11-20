package com.sit.swprocess.DogeCommerce.User;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.sit.swprocess.DogeCommerce.AuthenProvider.AuthenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private JwtService jwtService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id).get();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping(path = "")
    public ResponseEntity<User> getUserByEmail(@RequestParam(value = "email") String email) {
        Optional<User> user = userService.getUserByEmail(email);
        if(user.isPresent() == false) {
            throw new UserNotFoundException();
        }
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }

    @PostMapping(path = "/signin", produces = "application/json")
    public ResponseEntity<String> signInUsingUsername(@RequestBody(required = true) Map<String,Object> jsonBody,
                                                      HttpServletResponse response) {
        String username = jsonBody.get("username").toString();
        String password = jsonBody.get("password").toString();
        User user = userService.getByEmailOrUsername(username, username);
        if(user != null) {
            String userPassword = user.getPassword();
            if(userPassword.equals(password)) {
                String token = jwtService.encodeUser(user);
                String responseJson = "{\"token\": \""+ token +"\",\"userId\":"+ user.getId() +"}";
                return new ResponseEntity<String>(responseJson, HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("{\"token\": "+ null +",\"userId\":"+ null +"}", HttpStatus.FORBIDDEN);
    }

    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<User> create(@RequestBody(required = true) User user) {
        User newUser = userService.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PostMapping(path = "/signin/fb", produces = "application/json")
    public ResponseEntity<String> signinWithFacebook(@RequestBody(required = true) Map<String, Object> jsonBody) {
        String facebookToken = jsonBody.get("token").toString();
        String firstName = jsonBody.get("firstName").toString();
        String lastName = jsonBody.get("lastName").toString();
        String email = jsonBody.get("email").toString();
        User userFromEmail = userService.getUserByEmail(email).get();
        if( userFromEmail == null ) {
            User user = userService.getUserByFacebookToken(facebookToken);
            if( user != null) {
                String token = jwtService.encodeUser(user);
                String responseJson = "{\"token\": \""+ token +"\",\"userId\":"+ user.getId() +"}";
                return new ResponseEntity<String>(responseJson, HttpStatus.OK);
            }else {
                AuthenProvider authenProvider = new AuthenProvider("Facebook", facebookToken);
                List<AuthenProvider> authenProviderList = new ArrayList<>();
                authenProviderList.add(authenProvider);
                user = new User(null, firstName, null, email, firstName, lastName, null, authenProviderList);
                User newUser = userService.saveUser(user);

                String token = jwtService.encodeUser(user);
                String responseJson = "{\"token\": \""+ token +"\",\"userId\":"+ newUser.getId() +"}";
                return new ResponseEntity<String>(responseJson, HttpStatus.OK);
            }
        }else {
            return new ResponseEntity<String>("{\"token\": "+ null +",\"userId\":"+ null +"}", HttpStatus.FORBIDDEN);
        }
    }
}
