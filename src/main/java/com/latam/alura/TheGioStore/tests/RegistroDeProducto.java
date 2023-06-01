package com.latam.alura.TheGioStore.tests;

import com.latam.alura.TheGioStore.dao.ProductoDAO;
import com.latam.alura.TheGioStore.modelo.Producto;
import com.latam.alura.TheGioStore.utils.JPAUtils;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author giova
 */
public class RegistroDeProducto {
    
    public static void main(String[] args) {
        
        Producto celular = new Producto();
        
        celular.setNombrePro("Samsumg");
        celular.setDescripcionPro("Telefono Usado");
        celular.setPrecioPro(new BigDecimal("1000"));
        
        EntityManager ManejadorEntidad = JPAUtils.recuperarConexion();
        
        ProductoDAO productoDao = new ProductoDAO(ManejadorEntidad);
        
        ManejadorEntidad.getTransaction().begin(); //Iniciamos la transaccion
        
        productoDao.guardar(celular); //Realizamos la persistencia
        
        ManejadorEntidad.getTransaction().commit();//Enviamos a la BD
        ManejadorEntidad.close(); // Cerramos la conexion
    }
    
}
