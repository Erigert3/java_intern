package com.example.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "booking_date")
    private Date date;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "booking_flight",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id")
    )
    private Set<Flight> flights = new HashSet<>();

}


