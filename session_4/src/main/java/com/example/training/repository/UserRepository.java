package com.example.training.repository;

import com.example.training.entity.User;
import com.example.training.util.Util;
import jakarta.persistence.EntityManager;

public class UserRepository {

    public void saveUser(User user){
        EntityManager em = Util.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }
}
