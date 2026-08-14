package com.example.hotel_ms.repository;

import com.example.hotel_ms.entity.GuestProfile;
import com.example.hotel_ms.service.GuestService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestProfileRepository extends JpaRepository<GuestProfile, Long> {

    public Optional<GuestProfile> findByGuestId(Long id);
}
