package com.example.demo.controller;


import com.example.demo.model.UserEntity;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }
}


