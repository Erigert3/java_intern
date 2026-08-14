package com.example.hotel_ms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomCreateRequest {
    private String roomNumber;
    private String roomType;
    private Integer capacity;
    private Double pricePerNight;
}