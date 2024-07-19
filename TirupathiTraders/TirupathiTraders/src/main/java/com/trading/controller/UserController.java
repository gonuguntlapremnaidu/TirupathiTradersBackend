package com.trading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.trading.model.User;
import com.trading.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public String loginUser(@RequestBody User loginRequest) {
        User user = userService.findByEmail(loginRequest.getEmail())
                .orElseThrow(() ->
