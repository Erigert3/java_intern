package com.example.hotel_ms.service;

import com.example.hotel_ms.dto.RoomCreateRequest;
import com.example.hotel_ms.dto.RoomResponse;
import com.example.hotel_ms.dto.RoomStatusUpdateRequest;
import com.example.hotel_ms.entity.Hotel;
import com.example.hotel_ms.entity.Room;
import com.example.hotel_ms.repository.HotelRepository;
import com.example.hotel_ms.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    public RoomResponse addRoomToHotel(Long hotelId, RoomCreateRequest request) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new EntityNotFoundException());

        Room room = new Room(
                request.getRoomNumber(),
                request.getRoomType(),
                request.getCapacity(),
                request.getPricePerNight(),
                Room.RoomStatus.AVAILABLE,
                hotel
        );

        Room saved = roomRepository.save(room);
        return toResponse(saved);
    }

    public List<RoomResponse> getRoomsByHotel(Long hotelId) {
        if (!hotelRepository.existsById(hotelId)) {
            throw new EntityNotFoundException();
        }
        return roomRepository.findByHotelId(hotelId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public RoomResponse getRoomById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        return toResponse(room);
    }

    public RoomResponse updateRoom(Long id, RoomCreateRequest request) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        room.setRoomNumber(request.getRoomNumber());
        room.setRoomType(request.getRoomType());
        room.setCapacity(request.getCapacity());
        room.setPricePerNight(request.getPricePerNight());

        Room updated = roomRepository.save(room);
        return toResponse(updated);
    }

    public RoomResponse updateRoomStatus(Long id, RoomStatusUpdateRequest request) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        if(room.getStatus() != Room.RoomStatus.AVAILABLE){
            throw new IllegalStateException("Room " + id + " is not available (current status: " + room.getStatus() + ")");
        }
        room.setStatus(request.getStatus());

        Room updated = roomRepository.save(room);
        return toResponse(updated);
    }

    public void deleteRoom(Long id) {
        if (!roomRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        roomRepository.deleteById(id);
    }

    private RoomResponse toResponse(Room room) {
        return new RoomResponse(
                room.getId(),
                room.getRoomNumber(),
                room.getRoomType(),
                room.getCapacity(),
                room.getPricePerNight(),
                room.getStatus(),
                room.getHotel().getId()
        );
    }
}