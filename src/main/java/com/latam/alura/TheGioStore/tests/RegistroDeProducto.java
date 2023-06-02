package com.latam.alura.TheGioStore.tests;

import com.latam.alura.TheGioStore.dao.ProductoDAO;
import com.latam.alura.TheGioStore.modelo.Producto;
import com.latam.alura.TheGioStore.modelo.Categoria;
import com.latam.alura.TheGioStore.utils.JPAUtils;
import java.math.BigDecimal;
import javax.persistence.EntityManager;

/**
 *
 * @author giova
 */
public class RegistroDeProducto {
    
    public static void main(String[] args) {
        
        Categoria celulares = new Categoria("Celulares");
        
        Producto celular = new Producto("Samsumg",
                                        "Telefono Usado",
                                        10 , 
                                        new BigDecimal("1000"),
                                        celulares);
        
        
        EntityManager ManejadorEntidad = JPAUtils.recuperarConexion();
        
        ProductoDAO productoDao = new ProductoDAO(ManejadorEntidad);
        
        ManejadorEntidad.getTransaction().begin(); //Iniciamos la transaccion
        
        productoDao.guardar(celular); //Realizamos la persistencia
        
        ManejadorEntidad.getTransaction().commit();//Enviamos a la BD
        ManejadorEntidad.close(); // Cerramos la conexion
    }
    
}
