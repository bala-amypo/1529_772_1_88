package com.example.demo.service;

import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository repository;

    public FacilityServiceImpl(FacilityRepository repository) {
        this.repository = repository;
    }

    public Facility addFacility(Facility facility) {
        return repository.save(facility);
    }

    public List<Facility> getAllFacilities() {
        return repository.findAll();
    }
}
