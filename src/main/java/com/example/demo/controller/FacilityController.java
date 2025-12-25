package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Facility;
import com.example.demo.service.FacilityService;

@RestController
@RequestMapping("/facility")
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping
    public Facility addFacility(@RequestBody Facility facility) {
        return facilityService.saveFacility(facility);
    }
}
