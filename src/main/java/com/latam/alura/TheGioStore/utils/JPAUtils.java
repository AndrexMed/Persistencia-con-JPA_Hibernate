package com.latam.alura.TheGioStore.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author giova
 */
public class JPAUtils {
    
    private static EntityManagerFactory FABRICA = Persistence.createEntityManagerFactory("TheGioStore");
    
    public static EntityManager recuperarConexion(){
        return FABRICA.createEntityManager();
    }
}
