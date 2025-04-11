package com.socialmedia.controllers;

import com.socialmedia.dto.LoginRequest;
import com.socialmedia.dto.RegisterRequest;
import com.socialmedia.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.ok("User registered successfully!");
    }

  /*  @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest request) {
        String token = authService.login(request);
        return token != null
                ? ResponseEntity.ok("Bearer " + token)
                : ResponseEntity.status(401).body("Invalid credentials");
    }*/
}
