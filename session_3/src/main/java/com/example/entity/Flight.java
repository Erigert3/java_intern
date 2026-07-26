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

    public Flight(){}

    public Flight(String origin, String destination, String airline) {
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
