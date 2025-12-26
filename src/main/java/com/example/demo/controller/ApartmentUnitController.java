package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ApartmentUnitServiceImpl;

@RestController
@RequestMapping("/apartment-units")
public class ApartmentUnitController {

    private final ApartmentUnitServiceImpl service;

    public ApartmentUnitController(ApartmentUnitServiceImpl service) {
        this.service = service;
    }
}
