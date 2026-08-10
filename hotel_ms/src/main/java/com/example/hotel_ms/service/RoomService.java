package com.example.hotel_ms.service;

import com.example.hotel_ms.entity.Hotel;
import com.example.hotel_ms.entity.Room;
import com.example.hotel_ms.repository.HotelRepository;
import com.example.hotel_ms.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    public Room reserveRoom(Long roomId){
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new EntityNotFoundException());
        if(room.getStatus() != Room.RoomStatus.AVAILABLE){
            throw new IllegalStateException("Room with ID: " + + roomId + " not available" );
        }
        room.setStatus(Room.RoomStatus.OCCUPIED);
        return roomRepository.save(room);
    }

    public Optional<List<Room>> getAllRooms() {
        return Optional.of(roomRepository.findAll());
    }

    public Optional<Hotel> getHotelOfRoom(Long roomId){
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new EntityNotFoundException());
        return Optional.of(room.getHotel());
    }
}
