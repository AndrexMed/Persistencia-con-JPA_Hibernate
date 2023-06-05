package com.latam.alura.TheGioStore.tests;

import com.latam.alura.TheGioStore.modelo.Categoria;
import com.latam.alura.TheGioStore.utils.JPAUtils;
import javax.persistence.EntityManager;

/**
 *
 * @author giova
 */
public class RegistroDeProductoV3 {
    public static void main(String[] args) {
        
        System.out.println("Hello World");
        
        Categoria categoria = new Categoria("Tvs");
        
        EntityManager conexion = JPAUtils.recuperarConexion(); //Establecemos conexion
        
        conexion.getTransaction().begin(); //Iniciamos transaccion
        
        conexion.persist(categoria); // Pasamos el obj categoria al estado Managed
        
        categoria.setNombreCategoria("Televisores"); //Cambio prueba
        
        conexion.flush(); //Sincronizamos cambios
        
        conexion.clear(); //Frenamos los cambios regresa el obj a Datashed
        
        categoria = conexion.merge(categoria); //Volvemos abrir la persistencia
        
        categoria.setNombreCategoria("Software"); //Cambio de prueba
        
        conexion.flush(); // Sincronizamos cambios con la bd
        
        conexion.getTransaction().commit(); //Confirmamos los cambios a la BD
        
        //conexion.close();
        
        System.out.println("Hola Mundo");
    }
    
}
