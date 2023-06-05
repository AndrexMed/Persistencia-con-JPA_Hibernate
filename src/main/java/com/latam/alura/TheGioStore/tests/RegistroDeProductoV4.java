package com.latam.alura.TheGioStore.tests;

import com.latam.alura.TheGioStore.modelo.Categoria;
import com.latam.alura.TheGioStore.utils.JPAUtils;
import javax.persistence.EntityManager;

/**
 *
 * @author giova
 */
public class RegistroDeProductoV4 {
     public static void main(String[] args) {
        
        System.out.println("Hello World");
        
        Categoria categoria = new Categoria("PC");
        
        EntityManager conexion = JPAUtils.recuperarConexion(); //Establecemos conexion
        
        conexion.getTransaction().begin(); //Iniciamos transaccion
        
        conexion.persist(categoria); //Pasamos el obj al estado Managed
        
        categoria.setNombreCategoria("Computadores"); //Cambio prueba
        
        conexion.flush(); //Sincronizamos cambios   
        conexion.clear(); //Borra cambios en la memoria, en este caso categoria se vuelve entidad "desconectada"
        
        categoria = conexion.merge(categoria); //Volvemos abrir la persistencia
        categoria.setNombreCategoria("Tabletas"); //Cambio de prueba
        
        conexion.flush(); // Sincronizamos cambios con la bd    
        conexion.clear();  //Borramos los cambios del Managed
        
        categoria = conexion.merge(categoria);  //Volvemos a subir el obj al Managed 
        conexion.remove(categoria);     
        conexion.flush();
          
        conexion.getTransaction().commit();
        System.out.println("Hola Mundo");
    }
}
