package com.example.hotel_ms.repository;

import com.example.hotel_ms.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    public List<Room> findByHotelId (Long hotelId);

}
