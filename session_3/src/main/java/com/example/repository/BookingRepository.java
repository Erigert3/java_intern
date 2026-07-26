package com.example.repository;

import com.example.entity.Booking;
import com.example.entity.Flight;
import com.example.util.Util;
import jakarta.persistence.EntityManager;

import java.util.Collections;
import java.util.List;

public class BookingRepository {

    public void saveBooking(Booking booking) {
        EntityManager em = Util.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(booking);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Could not add Booking to database: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deleteBooking(int id) {
        EntityManager em = Util.getEntityManager();
        try {
            em.getTransaction().begin();
            Booking booking = em.find(Booking.class, id);
            if (booking != null) {
                em.remove(booking);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Booking with id: " + id + " could not be deleted: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Booking findBookingById(int id) {
        try (EntityManager em = Util.getEntityManager()) {
            return em.find(Booking.class, id);
        } catch (Exception e) {
            System.out.println("Booking with id: " + id + " was not found in the database: " + e.getMessage());
        }
        return null;
    }

    public List<Booking> getAllBookings() {
        try (EntityManager em = Util.getEntityManager()) {
            return em.createQuery("SELECT b FROM Booking b", Booking.class).getResultList();
        } catch (Exception e) {
            System.out.println("Could not get list of all bookings: " + e.getMessage());
        }
        return Collections.emptyList();
    }


    public void addFlightToBooking(int bookingId, int flightId) {
        EntityManager em = Util.getEntityManager();
        try {
            em.getTransaction().begin();
            Booking booking = em.find(Booking.class, bookingId);
            Flight flight = em.find(Flight.class, flightId);
            if (booking != null && flight != null) {
                booking.getFlights().add(flight);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Could not associate flight " + flightId + " with booking " + bookingId + ": " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
