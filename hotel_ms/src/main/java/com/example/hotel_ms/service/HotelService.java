package com.example.hotel_ms.service;

import com.example.hotel_ms.HotelMsApplication;
import com.example.hotel_ms.entity.Hotel;
import com.example.hotel_ms.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    public Optional<List<Hotel>> getAllHotels(){
        return Optional.of(hotelRepository.findAll());
    }
}
