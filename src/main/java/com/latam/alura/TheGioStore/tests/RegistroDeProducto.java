package com.latam.alura.TheGioStore.tests;

import com.latam.alura.TheGioStore.modelo.Producto;
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
        
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("TheGioStore");
        EntityManager ManejadorEntidad = fabrica.createEntityManager();
        
        ManejadorEntidad.persist(celular);
    }
    
}
