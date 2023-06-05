package com.latam.alura.TheGioStore.dao;

import com.latam.alura.TheGioStore.modelo.Producto;
import java.math.BigDecimal;
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
    
    public List<Producto> consultaPorNombre(String nombreEntrante){
        String consultaJQPL = "SELECT P FROM Producto AS P WHERE P.nombrePro = :nombrePro";
        return this.conexion.createQuery(consultaJQPL, Producto.class).setParameter("nombrePro", nombreEntrante).getResultList();
    }
    
    public List<Producto> consultaPorNombreCategoria(String nombreCategoriaEntrante){
        String consultaJQPL = "SELECT P FROM Producto AS P WHERE P.categoria.nombreCategoria = :nombreCat";
        return this.conexion.createQuery(consultaJQPL, Producto.class).setParameter("nombreCat", nombreCategoriaEntrante).getResultList();
    }
    
    public BigDecimal consultarPrecioPorNombreProducto (String nombreEntrante){
        String consultaJQPL = "SELECT P.precioPro FROM Producto P WHERE P.nombrePro = :Parametro";
        return this.conexion.createQuery(consultaJQPL, BigDecimal.class).setParameter("Parametro", nombreEntrante).getSingleResult();
    }
    
}
