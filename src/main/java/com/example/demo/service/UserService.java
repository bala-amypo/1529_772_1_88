package com.example.demo.service;


import com.example.demo.model.UserEntity;

public interface UserService {
    UserEntity createUser(UserEntity user);
    java.util.List<UserEntity> getAllUsers();

}
