package com.example.demo.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;

@Service
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;

    public FacilityServiceImpl(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    @Override
    public Facility saveFacility(Facility facility) {

        LocalTime openTime = facility.getOpenTime();
        LocalTime closeTime = facility.getCloseTime();

        if (openTime.isAfter(closeTime)) {
            throw new RuntimeException("Invalid facility time");
        }

        return facilityRepository.save(facility);
    }
}
