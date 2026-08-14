package com.example.hotel_ms.repository;

import com.example.hotel_ms.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository <Guest, Long> {
}
