package com.example.hotel_ms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GuestProfileResponse {
    private Long id;
    private String address;
    private LocalDate dateOfBirth;
    private String nationality;
    private String preferredLanguage;
    private Long guestId;
}