package com.example.demo.service;

import com.example.demo.model.UserEntity;

public interface UserService {

    UserEntity register(UserEntity user);

    UserEntity findByEmail(String email);
}
