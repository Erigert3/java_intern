package com.example.hotel_ms.service;

import com.example.hotel_ms.dto.GuestCreateRequest;
import com.example.hotel_ms.dto.GuestResponse;
import com.example.hotel_ms.entity.Guest;
import com.example.hotel_ms.repository.GuestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public GuestResponse createGuest(GuestCreateRequest request) {
        Guest guest = new Guest();
        guest.setFirstName(request.getFirstName());
        guest.setLastName(request.getLastName());
        guest.setEmail(request.getEmail());
        guest.setPhoneNumber(request.getPhoneNumber());

        Guest saved = guestRepository.save(guest);
        return toResponse(saved);
    }

    public List<GuestResponse> getAllGuests() {
        return guestRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public GuestResponse getGuestById(Long id) {
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        return toResponse(guest);
    }

    public GuestResponse updateGuest(Long id, GuestCreateRequest request) {
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        guest.setFirstName(request.getFirstName());
        guest.setLastName(request.getLastName());
        guest.setEmail(request.getEmail());
        guest.setPhoneNumber(request.getPhoneNumber());

        Guest updated = guestRepository.save(guest);
        return toResponse(updated);
    }

    private GuestResponse toResponse(Guest guest) {
        return new GuestResponse(
                guest.getId(),
                guest.getFirstName(),
                guest.getLastName(),
                guest.getEmail(),
                guest.getPhoneNumber()
        );
    }
}