package com.example.demo.service;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartmentUnitServiceImp implements ApartmentUnitService {

    @Autowired
    private ApartmentUnitRepository apartmentUnitRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        unit.setUser(user);
        return apartmentUnitRepository.save(unit);
    }

    @Override
    public ApartmentUnit getUnitByUser(Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return apartmentUnitRepository.findByUser(user).orElseThrow(() -> new RuntimeException("Unit not found"));
    }
}