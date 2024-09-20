package com.lydiatechnology.flightticket.security;

import com.lydiatechnology.flightticket.entity.User;
import com.lydiatechnology.flightticket.repository.UserRespository;
import com.lydiatechnology.flightticket.request.CreateUpdateUserRequest;
import com.lydiatechnology.flightticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserRespository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody CreateUpdateUserRequest createUpdateUserRequest) {
        if (userRepository.findByUserEmail(createUpdateUserRequest.getUserEmail()).isPresent()) {
            throw new RuntimeException("Username already exists!");
        }
        createUpdateUserRequest.setUserPassword(passwordEncoder.encode(createUpdateUserRequest.getUserPassword()));
        userService.createUser(createUpdateUserRequest);
        return "User registered successfully!";
    }
}

