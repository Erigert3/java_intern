package com.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Util {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example-pu");

    public static EntityManager getEntityManager (){
        return emf.createEntityManager();
    }

    public static void closeEmf(){
        if(emf.isOpen()){
            emf.close();
        }
    }
}
