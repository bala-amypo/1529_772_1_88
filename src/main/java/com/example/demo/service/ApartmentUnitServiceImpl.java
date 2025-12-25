package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.stereotype.Service;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository apartmentUnitRepository;
    private final UserRepository userRepository;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository apartmentUnitRepository,
                                    UserRepository userRepository) {
        this.apartmentUnitRepository = apartmentUnitRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit) {

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("Invalid user"));

        if (apartmentUnitRepository.existsByUnitNumber(unit.getUnitNumber())) {
            throw new BadRequestException("constraint violation");
        }

        unit.setOwner(user);
        return apartmentUnitRepository.save(unit);
    }

    @Override
    public ApartmentUnit getUnitByUser(Long userId) {

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("Invalid user"));

        return apartmentUnitRepository.findByOwner(user)
                .orElseThrow(() -> new BadRequestException("Apartment unit not found"));
    }
}
