package com.latam.alura.TheGioStore.dao;

import com.latam.alura.TheGioStore.modelo.Producto;
import javax.persistence.EntityManager;

/**
 *
 * @author giova
 */
public class ProductoDAO {
    
    private EntityManager em;

    //Constructor
    public ProductoDAO(EntityManager em) {
        this.em = em;
    }
    
    public void guardar(Producto producto){
        this.em.persist(producto);
    }
    
}
