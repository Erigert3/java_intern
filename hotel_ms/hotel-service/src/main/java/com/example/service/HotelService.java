package com.example.hotel_ms.service;

import com.example.hotel_ms.HotelMsApplication;
import com.example.hotel_ms.dto.HotelCreateRequest;
import com.example.hotel_ms.dto.HotelResponse;
import com.example.hotel_ms.entity.Hotel;
import com.example.hotel_ms.repository.HotelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }


    public HotelResponse createHotel(HotelCreateRequest request){
        Hotel hotel = new Hotel();
        hotel.setName(request.getName());
        hotel.setCity(request.getCity());
        hotel.setAddress(request.getAddress());
        hotel.setStarRating(request.getStarRating());

        Hotel saved = hotelRepository.save(hotel);
        return toResponse(saved);
    }

    public List<HotelResponse> getAllHotels(){
        return hotelRepository.findAll().stream().map(this::toResponse).toList();
    }

    public HotelResponse getHotelById(Long id){
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return toResponse(hotel);
    }

    public HotelResponse updateHotel(Long id, HotelCreateRequest request) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        hotel.setName(request.getName());
        hotel.setCity(request.getCity());
        hotel.setAddress(request.getAddress());
        hotel.setStarRating(request.getStarRating());

        Hotel updated = hotelRepository.save(hotel);
        return toResponse(updated);
    }

    public void deleteHotel(Long id) {
        if (!hotelRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        hotelRepository.deleteById(id);
    }


    private HotelResponse toResponse(Hotel hotel) {
        return new HotelResponse(
                hotel.getId(),
                hotel.getName(),
                hotel.getCity(),
                hotel.getAddress(),
                hotel.getStarRating()
        );
    }
}



