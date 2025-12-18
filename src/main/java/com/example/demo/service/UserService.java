package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.UserEntity;

public interface UserService {
    UserEntity createUser(UserEntity user);
    List<UserEntity> getAllUsers();
    Optional<UserEntity> getUserById(Long id);
    UserEntity updateUser(Long id, UserEntity user);
    void deleteUser(Long id);
}