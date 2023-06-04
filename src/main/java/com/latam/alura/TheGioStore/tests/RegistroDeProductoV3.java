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
        
        Categoria categoria = new Categoria("Televisores");
        
        EntityManager conexion = JPAUtils.recuperarConexion(); //Establecemos conexion
        
        conexion.getTransaction().begin(); //Iniciamos transaccion
        
        conexion.persist(categoria); //Esto indica que se guardara el obj categoria en la BD
        
        categoria.setNombreCategoria("Tvss"); //Cambio prueba
        
        conexion.flush(); //Sincronizamos cambios
        
        conexion.clear(); //Borra cambios en la memoria, en este caso categoria se vuelve entidad "desconectada"
        
        categoria = conexion.merge(categoria); //Volvemos abrir la persistencia
        
        categoria.setNombreCategoria("Software"); //Cambio de prueba
        
        conexion.flush(); // Sincronizamos cambios con la bd
        
        //conexion.close();
        
        System.out.println("Hola Mundo");
    }
    
}
