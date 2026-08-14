package com.example.hotel_ms.dto;

import com.example.hotel_ms.entity.Room.RoomStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponse {
    private Long id;
    private String roomNumber;
    private String roomType;
    private Integer capacity;
    private Double pricePerNight;
    private RoomStatus status;
    private Long hotelId;
}