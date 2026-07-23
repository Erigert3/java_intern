package com.example.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "user_detail")
public class UserDetails {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(mappedBy = "userDetails")
    private User user;
}
