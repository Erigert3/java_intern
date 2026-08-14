package com.example.hotel_ms.controller;

import com.example.hotel_ms.dto.GuestProfileCreateRequest;
import com.example.hotel_ms.dto.GuestProfileResponse;
import com.example.hotel_ms.service.GuestProfileService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guests/{guestId}/profile")
public class GuestProfileController {

    private final GuestProfileService guestProfileService;

    public GuestProfileController(GuestProfileService guestProfileService) {
        this.guestProfileService = guestProfileService;
    }

    @PostMapping
    public ResponseEntity<GuestProfileResponse> createGuestProfile(
            @PathVariable Long guestId,
            @Valid @RequestBody GuestProfileCreateRequest request) {
        GuestProfileResponse created = guestProfileService.createGuestProfile(guestId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<GuestProfileResponse> getGuestProfile(@PathVariable Long guestId) {
        return ResponseEntity.ok(guestProfileService.getGuestProfile(guestId));
    }
}