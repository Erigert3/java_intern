package com.example.hotel_ms.service;

import com.example.hotel_ms.dto.GuestProfileCreateRequest;
import com.example.hotel_ms.dto.GuestProfileResponse;
import com.example.hotel_ms.entity.Guest;
import com.example.hotel_ms.entity.GuestProfile;
import com.example.hotel_ms.repository.GuestProfileRepository;
import com.example.hotel_ms.repository.GuestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GuestProfileService {

    private final GuestProfileRepository guestProfileRepository;
    private final GuestRepository guestRepository;

    public GuestProfileService(GuestProfileRepository guestProfileRepository, GuestRepository guestRepository) {
        this.guestProfileRepository = guestProfileRepository;
        this.guestRepository = guestRepository;
    }

    public GuestProfileResponse createGuestProfile(Long guestId, GuestProfileCreateRequest request) {
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new EntityNotFoundException());

        GuestProfile profile = new GuestProfile();
        profile.setAddress(request.getAddress());
        profile.setDateOfBirth(request.getDateOfBirth());
        profile.setNationality(request.getNationality());
        profile.setPreferredLanguage(request.getPreferredLanguage());
        profile.setGuest(guest);

        GuestProfile saved = guestProfileRepository.save(profile);
        return toResponse(saved);
    }

    public GuestProfileResponse getGuestProfile(Long guestId) {
        if (!guestRepository.existsById(guestId)) {
            throw new EntityNotFoundException();
        }

        GuestProfile profile = guestProfileRepository.findByGuestId(guestId)
                .orElseThrow(() -> new EntityNotFoundException());

        return toResponse(profile);
    }

    private GuestProfileResponse toResponse(GuestProfile profile) {
        return new GuestProfileResponse(
                profile.getId(),
                profile.getAddress(),
                profile.getDateOfBirth(),
                profile.getNationality(),
                profile.getPreferredLanguage(),
                profile.getGuest().getId()
        );
    }
}