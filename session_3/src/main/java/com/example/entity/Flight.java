package com.example.entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "airline")
    private String airline;

    @Column(name = "flight_number")
    private int flightNumber;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "status")
    private String status;

    @ManyToMany(mappedBy = "flights")
    private Set<Booking> bookings = new HashSet<>();

    public Flight(String origin, String destination, String airline) {
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
    }
}
