package com.example.repository;

import com.example.entity.Flight;
import com.example.util.Util;
import jakarta.persistence.EntityManager;

import java.util.Collections;
import java.util.List;

public class FlightRepository {

    public void saveFlight(Flight flight) {
        EntityManager em = Util.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(flight);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Could not add Flight to database: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deleteFlight(int id) {
        EntityManager em = Util.getEntityManager();
        try {
            em.getTransaction().begin();
            Flight flight = em.find(Flight.class, id);
            if (flight != null) {
                em.remove(flight);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Flight with id: " + id + " could not be deleted: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Flight findFlightById(int id) {
        try (EntityManager em = Util.getEntityManager()) {
            return em.find(Flight.class, id);
        } catch (Exception e) {
            System.out.println("Flight with id: " + id + " was not found in the database: " + e.getMessage());
        }
        return null;
    }

    public List<Flight> getAllFlights() {
        try (EntityManager em = Util.getEntityManager()) {
            return em.createQuery("SELECT f FROM Flight f", Flight.class).getResultList();
        } catch (Exception e) {
            System.out.println("Could not get list of all flights: " + e.getMessage());
        }
        return Collections.emptyList();
    }

}
