package com.latam.alura.TheGioStore.dao;

import com.latam.alura.TheGioStore.modelo.Producto;
import javax.persistence.EntityManager;

/**
 *
 * @author giova
 */
public class ProductoDAO {
    
    private EntityManager conexion;

    //Constructor
    public ProductoDAO(EntityManager em) {
        this.conexion = em;
    }
    
    public void guardar(Producto producto){
        this.conexion.persist(producto);
    }
    
    public void actualizar(Producto producto){
        this.conexion.merge(producto);
    }
    
    public void remover(Producto producto){
        this.conexion.merge(producto);
        this.conexion.remove(producto);
    }
    
}
