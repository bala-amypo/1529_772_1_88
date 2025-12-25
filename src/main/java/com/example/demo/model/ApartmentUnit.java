package com.example.demo.model;

public class ApartmentUnit {

    private Long id;
    private String name;
    private int floor;
    private User owner;

    public ApartmentUnit() {
    }

    public ApartmentUnit(String name, int floor, User owner) {
        this.name = name;
        this.floor = floor;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
