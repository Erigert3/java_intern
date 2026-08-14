package com.example.hotel_ms.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GuestProfileCreateRequest {
    private String address;
    private LocalDate dateOfBirth;
    private String nationality;
    private String preferredLanguage;
}