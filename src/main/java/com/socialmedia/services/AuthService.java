package com.socialmedia.services;

import com.socialmedia.dto.LoginRequest;
import com.socialmedia.dto.RegisterRequest;
import com.socialmedia.models.User;
import com.socialmedia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register a new user
    public User register(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPasswordHash(passwordEncoder.encode(registerRequest.getPassword()));
        return userRepository.save(user);
    }

    // Authenticate user login
  /*  public String login(LoginRequest loginRequest) {
        return userRepository.findByUsername(loginRequest.getUsername())
                .filter(user -> passwordEncoder.matches(loginRequest.getPassword(), user.getPasswordHash()))
                .map(this::generateToken)
                .orElse(null);
    }*/

    // Generate a mock token for the user
    private String generateToken(User user) {
        return "mock-token-for-" + user.getUsername();
    }
}
