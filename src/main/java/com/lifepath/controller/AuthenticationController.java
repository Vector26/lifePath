package com.lifepath.controller;
import com.lifepath.models.UserModel;
import com.lifepath.service.JwtTokenService;
import com.lifepath.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenService jwtTokenService;
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(@RequestBody UserModel user) {
        UserModel newUser = userService.registerUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> loginUser(@RequestBody UserModel user) {
        UserModel foundUser = userService.findByUsername(user.getUsername());
        if (foundUser != null && userService.passwordMatches(user.getPassword(), foundUser.getPassword())) {
            String token = jwtTokenService.generateToken(foundUser.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}

