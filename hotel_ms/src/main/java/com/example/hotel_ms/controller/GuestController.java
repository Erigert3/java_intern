package com.example.hotel_ms.controller;

import com.example.hotel_ms.dto.GuestCreateRequest;
import com.example.hotel_ms.dto.GuestResponse;
import com.example.hotel_ms.service.GuestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping
    public ResponseEntity<GuestResponse> createGuest(@Valid @RequestBody GuestCreateRequest request) {
        GuestResponse created = guestService.createGuest(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<GuestResponse>> getAllGuests() {
        return ResponseEntity.ok(guestService.getAllGuests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestResponse> getGuestById(@PathVariable Long id) {
        return ResponseEntity.ok(guestService.getGuestById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuestResponse> updateGuest(
            @PathVariable Long id,
            @Valid @RequestBody GuestCreateRequest request) {
        return ResponseEntity.ok(guestService.updateGuest(id, request));
    }
}