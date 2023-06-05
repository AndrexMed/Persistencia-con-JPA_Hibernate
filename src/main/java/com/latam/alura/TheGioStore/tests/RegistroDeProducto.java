package com.latam.alura.TheGioStore.tests;

import com.latam.alura.TheGioStore.dao.CategoriaDAO;
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
        
        Categoria categoria = new Categoria("Celulares");
        
        Producto celular = new Producto("Samsumg",
                                        "Telefono Usado, Blanco",
                                        10 , 
                                        new BigDecimal("1500"),
                                        categoria);
        
        
        EntityManager ManejadorEntidad = JPAUtils.recuperarConexion(); //Iniciamos la conexion
        
        ProductoDAO productoDao = new ProductoDAO(ManejadorEntidad);
        
        CategoriaDAO categoriaDao = new CategoriaDAO(ManejadorEntidad);
        
        ManejadorEntidad.getTransaction().begin(); //Iniciamos la transaccion
        
        productoDao.guardar(celular); //Realizamos la persistencia
        categoriaDao.guardar(categoria); // Pasamos los objetos a estado Managed
        
        ManejadorEntidad.getTransaction().commit();//Enviamos a la BD
        
        ManejadorEntidad.close(); // Cerramos la conexion
    }
    
}
