package com.latam.alura.TheGioStore.tests;

import com.latam.alura.TheGioStore.dao.CategoriaDAO;
import com.latam.alura.TheGioStore.dao.ProductoDAO;
import com.latam.alura.TheGioStore.modelo.Categoria;
import com.latam.alura.TheGioStore.modelo.Producto;
import com.latam.alura.TheGioStore.utils.JPAUtils;
import java.math.BigDecimal;
import javax.persistence.EntityManager;

/**
 *
 * @author giova
 */
public class ConsultasEntidades {

    public static void main(String[] args) {
        
        //registrarProducto(); // Metodo que guarda un registro de un producto y su categoria...

        EntityManager ManejadorEntidad = JPAUtils.recuperarConexion(); //Iniciamos la conexion

        ProductoDAO productoDao = new ProductoDAO(ManejadorEntidad); //Heredamos los metodos del DAO
        
        Producto producto = productoDao.consultaPorId(5l); // Almacenamos la consulta en una variable
        
        System.out.println("Se encontro el producto: " + producto.getNombrePro()); //Imprimimos el resultado

        
    }

    
    private static void registrarProducto() {
        Categoria categoria = new Categoria("Computadores");

        Producto computador = new Producto("Asus",
                "Nuevo",
                10,
                new BigDecimal("3000"),
                categoria);

        EntityManager ManejadorEntidad = JPAUtils.recuperarConexion(); //Iniciamos la conexion

        ProductoDAO productoDao = new ProductoDAO(ManejadorEntidad);

        CategoriaDAO categoriaDao = new CategoriaDAO(ManejadorEntidad);

        ManejadorEntidad.getTransaction().begin(); //Iniciamos la transaccion

        productoDao.guardar(computador); //Realizamos la persistencia por medio de su metodo
        categoriaDao.guardar(categoria);

        ManejadorEntidad.getTransaction().commit();//Enviamos a la BD
        ManejadorEntidad.close(); // Cerramos la conexion
    }

}
