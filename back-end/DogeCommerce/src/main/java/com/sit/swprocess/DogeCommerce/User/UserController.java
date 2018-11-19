package com.sit.swprocess.DogeCommerce.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    UserService userService;

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
}
