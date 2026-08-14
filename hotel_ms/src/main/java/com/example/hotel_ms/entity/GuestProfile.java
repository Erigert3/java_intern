package com.example.hotel_ms.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "guest_profiles")
@Getter
@Setter
public class GuestProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private LocalDate dateOfBirth;

    private String nationality;

    private String preferredLanguage;

    @OneToOne
    @JoinColumn(name = "guest_id", nullable = false, unique = true)
    private Guest guest;

    public GuestProfile() {}

}
