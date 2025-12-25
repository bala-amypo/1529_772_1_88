package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    UserEntity register(User user);

    UserEntity findByEmail(String email);
}
