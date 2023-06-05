package com.latam.alura.TheGioStore.tests;

import com.latam.alura.TheGioStore.modelo.Categoria;
import com.latam.alura.TheGioStore.utils.JPAUtils;
import javax.persistence.EntityManager;

/**
 *
 * @author giova
 */
public class RegistroDeProductoV2 {
    public static void main(String[] args) {
        
        Categoria categoria = new Categoria("Hogar"); //Representa entidad en BD
        
        EntityManager conexion = JPAUtils.recuperarConexion(); //Establecemos la conexion
        
        conexion.getTransaction().begin(); //Iniciamos la transaccion
        
        conexion.persist(categoria); //Pasamos el obj al estado Managed
        
        categoria.setNombreCategoria("Tests");
        
        conexion.getTransaction().commit(); //Confirmamos la transaccion y aplica cambios en BD
        
        conexion.close(); //Cerramos la Conexion!
        
        categoria.setNombreCategoria("Software"); //Realizamos un cambio de prueba - Esta parte no la compila ya que se cerro la conexion.
    }
    
}
