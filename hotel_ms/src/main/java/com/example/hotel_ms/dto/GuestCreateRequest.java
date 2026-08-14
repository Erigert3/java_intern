package com.example.hotel_ms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestCreateRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}