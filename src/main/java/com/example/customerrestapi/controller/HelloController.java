package com.example.customerrestapi.controller;

import com.example.customerrestapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String hello() {
        return "Welcome to CustomerAPI";
    }

    @PostMapping("/register")
    public User saveUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }
}
