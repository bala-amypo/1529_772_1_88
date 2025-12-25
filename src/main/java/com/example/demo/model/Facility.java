package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalTime openTime;
    private LocalTime closeTime;

    public Facility() {}

    public Facility(String name, LocalTime openTime, LocalTime closeTime) {
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public String getName() {
        return name;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }
}
