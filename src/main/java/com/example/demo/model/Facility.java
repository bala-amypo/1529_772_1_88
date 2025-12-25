package com.example.demo.model;

import java.time.LocalTime;

public class Facility {

    private Long id;
    private String name;
    private LocalTime openTime;
    private LocalTime closeTime;

    public Facility() {
    }

    public Facility(String name, LocalTime openTime, LocalTime closeTime) {
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public LocalTime getOpenTime() { return openTime; }
    public LocalTime getCloseTime() { return closeTime; }
}
