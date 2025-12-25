package com.example.demo.model;

public class ApartmentUnit {

    private Long id;
    private String unitNumber;
    private int floor;
    private User owner;

    public ApartmentUnit() {
    }

    public ApartmentUnit(String unitNumber, int floor, User owner) {
        this.unitNumber = unitNumber;
        this.floor = floor;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
