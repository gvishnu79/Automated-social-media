package com.socialmedia.services;





import com.socialmedia.models.User;
import com.socialmedia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // Encode the raw password
        user.setPasswordHash(bCryptPasswordEncoder
                .encode(user.getPasswordHash()));
       // String encodedPassword = passwordEncoder.encode(user.getPasswordHash());
       // user.setPasswordHash(encodedPassword);
        return userRepository.save(user);
    }
}
