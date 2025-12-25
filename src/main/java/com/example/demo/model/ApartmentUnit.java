package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitNumber;
    private int capacity;

    @ManyToOne
    private User owner;

    public ApartmentUnit() {}

    public ApartmentUnit(String unitNumber, int capacity, User owner) {
        this.unitNumber = unitNumber;
        this.capacity = capacity;
        this.owner = owner;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUnitNumber() { return unitNumber; }
    public void setUnitNumber(String unitNumber) { this.unitNumber = unitNumber; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
}
