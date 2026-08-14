package com.example.hotel_ms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelCreateRequest {

    private String name;
    private String city;
    private String address;
    private Integer starRating;

}
