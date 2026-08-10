package com.example.hotel_ms.controller;

import com.example.hotel_ms.entity.Hotel;
import com.example.hotel_ms.entity.Room;
import com.example.hotel_ms.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms(){
        return ResponseEntity.of(roomService.getAllRooms());
    }

    @GetMapping("/{id}/hotel")
    public ResponseEntity<Hotel> getHotelOfRoom(@PathVariable Long id){
        return ResponseEntity.of(roomService.getHotelOfRoom(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> reserveRoom (@PathVariable Long id){
        Room room = roomService.reserveRoom(id);
        return ResponseEntity.ok(room);
    }

}
