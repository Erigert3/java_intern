package com.example.repository;

import com.example.entity.User;
import com.example.util.Util;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class UserRepository {

    public void saveUser (User user){
        EntityManager em = Util.getEntityManager();
        em.getTransaction().begin();

        try{
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Could not add User to database: " + e.getMessage());
        }finally {
            em.close();
        }
    }

    public void deleteUser (int id){
        EntityManager em = Util.getEntityManager();
        try{
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            if (user != null){
                em.remove(user);
            }
        } catch (Exception e){
            em.getTransaction().rollback();
            System.out.println("User with id: " + id + "could not be deleted" + e.getMessage());
        } finally {
            em.close();
        }
    }

    public User findUserById(int id){
        try(EntityManager em = Util.getEntityManager()){
            return em.find(User.class,id);
        } catch (Exception e){
            System.out.println("User with id: " + id + " was not found in the datbase: " + e.getMessage());
        }
        return null;
    }

}
