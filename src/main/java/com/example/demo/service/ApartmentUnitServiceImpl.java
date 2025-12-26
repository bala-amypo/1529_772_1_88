package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.ApartmentUnitRepository;

@Service
public class ApartmentUnitServiceImpl {

    private final ApartmentUnitRepository repository;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository repository) {
        this.repository = repository;
    }
}
