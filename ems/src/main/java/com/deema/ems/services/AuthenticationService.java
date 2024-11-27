package com.deema.ems.services;

import com.deema.ems.dtos.LoginUserDto;
import com.deema.ems.entities.User;
import com.deema.ems.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(User input) {
//        var user = new User()
//                .setFullName(input.getFullName())
//                .setEmail(input.getEmail())
//                .setRole(input.getRole())
//                .setTeacher(input.getTeacher())
//                .setPassword(passwordEncoder.encode(input.getPassword()));
//        input.setPassword(passwordEncoder.encode(input.getPassword()));
        return userRepository.save(input);
    }

    public User authenticate(LoginUserDto input) {
        User user = userRepository.findByEmail(input.getEmail()).orElse(null);
        if (user == null ||  !user.getPassword().equals(input.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }
        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }

//    public List<User> allUsers() {
//        List<User> users = new ArrayList<>();
//
//        userRepository.findAll().forEach(users::add);
//
//        return users;
//    }
}
