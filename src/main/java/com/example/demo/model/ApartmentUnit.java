package com.example.demo.model;

public class ApartmentUnit {

    private String unitNumber;
    private int floor;
    private User user;

    public ApartmentUnit() {
    }

    public ApartmentUnit(String unitNumber, int floor, User user) {
        this.unitNumber = unitNumber;
        this.floor = floor;
        this.user = user;
    }

    public String getUnitNumber() { return unitNumber; }
    public int getFloor() { return floor; }
    public User getUser() { return user; }
}
