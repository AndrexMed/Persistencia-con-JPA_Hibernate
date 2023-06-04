package com.latam.alura.TheGioStore.dao;

import com.latam.alura.TheGioStore.modelo.Categoria;
import javax.persistence.EntityManager;

/**
 *
 * @author giova
 */
public class CategoriaDAO {
    
    private EntityManager conexion;

    //Constructor
    public CategoriaDAO(EntityManager conexionEntrante) {
        this.conexion = conexionEntrante;
    }
    
    public void guardar(Categoria categoria){
        this.conexion.persist(categoria);
    }
    
    public void actualizar(Categoria categoria){
        this.conexion.merge(categoria);
    }
    
}
