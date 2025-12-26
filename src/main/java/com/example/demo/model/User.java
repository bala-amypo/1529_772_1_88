package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    // ✅ DEFAULT ROLE REQUIRED BY TESTS
    private String role = "RESIDENT";

    @OneToOne(mappedBy = "owner")
    private ApartmentUnit apartmentUnit;

    // ✅ REQUIRED constructor used heavily in tests
    public User(Long id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = (role != null) ? role : "RESIDENT";
    }
}
