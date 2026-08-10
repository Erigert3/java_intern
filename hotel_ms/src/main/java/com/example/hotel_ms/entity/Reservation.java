package com.example.hotel_ms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "reservations")
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    checkInDate
//    checkOutDate
//            numberOfGuests,
//    totalPrice
//    status
//
//            createdAt

}
