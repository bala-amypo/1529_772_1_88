
package com.example.demo.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import com.example.demo.model.Facility;

@Service
public class FacilityServiceImpl implements FacilityService {

    @Override
    public Facility saveFacility(Facility facility) {
        return facility;
    }

    @Override
    public List<Facility> getAllFacilities() {
        return new ArrayList<>();
    }
}
