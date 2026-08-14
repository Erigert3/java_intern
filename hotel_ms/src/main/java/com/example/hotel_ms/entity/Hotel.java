package com.example.hotel_ms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "hotels")
@Getter
@Setter
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String city;

    private String address;

    private Integer starRating;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms;

    public Hotel() {}

    public Hotel(String name, String city, String address, Integer starRating) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.starRating = starRating;
    }
}
