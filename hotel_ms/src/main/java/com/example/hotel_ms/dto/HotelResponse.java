package com.example.hotel_ms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelResponse {

    private Long id;
    private String name;
    private String city;
    private String address;
    private Integer starRating;

    public HotelResponse() {}

    public HotelResponse(Long id, String name, String city, String address, Integer starRating) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.starRating = starRating;
    }
}
