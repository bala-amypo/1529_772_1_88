package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    UserEntity register(UserEntity user);

    UserEntity findByEmail(String email);
}
