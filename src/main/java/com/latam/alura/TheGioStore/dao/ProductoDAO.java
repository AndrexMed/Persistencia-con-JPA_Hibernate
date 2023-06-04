package com.latam.alura.TheGioStore.dao;

import com.latam.alura.TheGioStore.modelo.Producto;
import java.util.List;
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
    
    //Metodo que recibe una id, donde la buscamos en la entidad Producto.
    public Producto consultaPorId(Long id){
        return this.conexion.find(Producto.class, id);
    }
    
    public List<Producto> consultarTodos(){
        String consultaJQPL = "SELECT P FROM Producto AS P"; //Esta consulta distingue Mayus y Minus
        return this.conexion.createQuery(consultaJQPL, Producto.class).getResultList();
    }
    
}
