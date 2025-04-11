package com.socialmedia.controllers;

import com.socialmedia.models.User;
import com.socialmedia.repositories.UserRepository;
import com.socialmedia.services.AuthService;
import com.socialmedia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
//@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private AuthService authService;



    @Autowired
    private UserService userService;
    private  UserRepository userRepository;

    /*@GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return authService.getUserByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error registering user: " + e.getMessage());
        }
    }*/


    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        var u = userRepository.findByUsername(user.getUsername());
        if(!Objects.isNull(u)){
            return "success";
        }
        else{
            return "failure";
        }
    }

}
