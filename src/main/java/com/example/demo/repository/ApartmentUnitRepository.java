package com.example.demo.repository;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {

    Optional<ApartmentUnit> findByOwner(UserEntity owner);

    boolean existsByUnitNumber(String unitNumber);
}
