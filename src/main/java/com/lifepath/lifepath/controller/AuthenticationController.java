package com.lifepath.lifepath.controller;


import com.lifepath.lifepath.models.UserModel;
import com.lifepath.lifepath.service.JwtTokenService;
import com.lifepath.lifepath.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserModel user) {
        UserModel newUser = userService.registerUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserModel user) {
        UserModel foundUser = userService.findByUsername(user.getUsername());
        if (foundUser != null && userService.passwordMatches(user.getPassword(), foundUser.getPassword())) {
            String token = jwtTokenService.generateToken(foundUser.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}

