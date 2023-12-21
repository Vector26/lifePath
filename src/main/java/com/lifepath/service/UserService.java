package com.lifepath.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lifepath.dto.UserResponseDTO;
import com.lifepath.events.publishers.UserCreatedEvent;
import com.lifepath.models.UserModel;
import com.lifepath.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private ObjectMapper objectMapper;

    @Autowired
    private ApplicationContext context;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ObjectMapper objectMapper, ApplicationContext context) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.objectMapper = new ObjectMapper();
        this.context = context;
    }

    public UserResponseDTO registerUser(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserModel savedUser = userRepository.save(user);
        UserResponseDTO dto = objectMapper.convertValue(savedUser, UserResponseDTO.class);
        // Publish Event For Profile Creator Listener to Catch
        context.publishEvent(new UserCreatedEvent(this, savedUser));
        return dto;
    }

    public UserModel findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public boolean passwordMatches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

}

