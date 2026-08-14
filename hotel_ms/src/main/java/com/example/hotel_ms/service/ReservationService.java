package com.example.hotel_ms.service;

import com.example.hotel_ms.dto.ReservationCreateRequest;
import com.example.hotel_ms.dto.ReservationResponse;
import com.example.hotel_ms.dto.ReservationStatusUpdateRequest;
import com.example.hotel_ms.entity.Guest;
import com.example.hotel_ms.entity.Reservation;
import com.example.hotel_ms.entity.Room;
import com.example.hotel_ms.repository.GuestRepository;
import com.example.hotel_ms.repository.ReservationRepository;
import com.example.hotel_ms.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;

    public ReservationService(ReservationRepository reservationRepository,
                              GuestRepository guestRepository,
                              RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }

    public ReservationResponse createReservation(ReservationCreateRequest request) {
        Guest guest = guestRepository.findById(request.getGuestId())
                .orElseThrow(() -> new EntityNotFoundException("Guest not found with id: " + request.getGuestId()));

        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new EntityNotFoundException("Room not found with id: " + request.getRoomId()));

        long nights = ChronoUnit.DAYS.between(request.getCheckInDate(), request.getCheckOutDate());
        if (nights <= 0) {
            throw new IllegalArgumentException("Check-out date must be after check-in date");
        }

        BigDecimal totalPrice = BigDecimal.valueOf(room.getPricePerNight())
                .multiply(BigDecimal.valueOf(nights));

        Reservation reservation = new Reservation();
        reservation.setGuest(guest);
        reservation.setRoom(room);
        reservation.setCheckInDate(request.getCheckInDate());
        reservation.setCheckOutDate(request.getCheckOutDate());
        reservation.setNumberOfGuests(request.getNumberOfGuests());
        reservation.setTotalPrice(totalPrice);
        reservation.setStatus(Reservation.ReservationStatus.PENDING);

        Reservation saved = reservationRepository.save(reservation);
        return toResponse(saved);
    }

    public List<ReservationResponse> getAllReservations() {
        return reservationRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public ReservationResponse getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));
        return toResponse(reservation);
    }

    public ReservationResponse updateReservationStatus(Long id, ReservationStatusUpdateRequest request) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));

        reservation.setStatus(request.getStatus());

        Reservation updated = reservationRepository.save(reservation);
        return toResponse(updated);
    }

    public void cancelReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));

        reservation.setStatus(Reservation.ReservationStatus.CANCELLED);
        reservationRepository.save(reservation);
    }

    private ReservationResponse toResponse(Reservation reservation) {
        return new ReservationResponse(
                reservation.getId(),
                reservation.getCheckInDate(),
                reservation.getCheckOutDate(),
                reservation.getNumberOfGuests(),
                reservation.getTotalPrice(),
                reservation.getStatus(),
                reservation.getCreatedAt(),
                reservation.getGuest().getId(),
                reservation.getRoom().getId()
        );
    }
}