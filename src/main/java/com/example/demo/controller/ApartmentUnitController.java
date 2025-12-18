package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApartmentUnitController {

    @Autowired
    private ApartmentUnitService apartmentUnitService;

    @PostMapping("/assignunit")
    public ApartmentUnit assignUnitToUser(@RequestParam Long userId, @RequestBody ApartmentUnit unit) {
        return apartmentUnitService.assignUnitToUser(userId, unit);
    }

    @GetMapping("/unit/{userId}")
    public ApartmentUnit getUnitByUser(@PathVariable Long userId) {
        return apartmentUnitService.getUnitByUser(userId);
    }
}