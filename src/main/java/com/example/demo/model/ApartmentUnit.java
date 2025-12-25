package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitNumber;

    @ManyToOne
    private User owner;

    public ApartmentUnit() {}

    public ApartmentUnit(String unitNumber, int floor, User owner) {
        this.unitNumber = unitNumber;
        this.owner = owner;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUnitNumber() { return unitNumber; }
    public void setUnitNumber(String unitNumber) { this.unitNumber = unitNumber; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
}
