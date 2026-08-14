package com.example.hotel_ms.dto;

import com.example.hotel_ms.entity.Room.RoomStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomStatusUpdateRequest {
    private RoomStatus status;
}