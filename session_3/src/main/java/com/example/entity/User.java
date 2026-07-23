package com.example.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToOne
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;

    public User (String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @OneToMany(mappedBy = "user")
    private ArrayList<Booking> bookings;
}
