package com.example.hotel_ms.dto;

import com.example.hotel_ms.entity.Reservation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationStatusUpdateRequest {
    private Reservation.ReservationStatus status;
}