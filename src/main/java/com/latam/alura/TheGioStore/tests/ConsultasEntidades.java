package com.latam.alura.TheGioStore.tests;

import com.latam.alura.TheGioStore.dao.CategoriaDAO;
import com.latam.alura.TheGioStore.dao.ProductoDAO;
import com.latam.alura.TheGioStore.modelo.Categoria;
import com.latam.alura.TheGioStore.modelo.Producto;
import com.latam.alura.TheGioStore.utils.JPAUtils;
import java.math.BigDecimal;
import java.util.List;
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

        Producto productoPorId = productoDao.consultaPorId(5l); // Almacenamos la consulta en una variable, se agrega la "l" para decirle que es de tipo Long

        System.out.println("*****");
        System.out.println("Se encontro el productoPorID: " + productoPorId.getNombrePro()); //Imprimimos el resultado
        System.out.println("*****");

        List<Producto> TodosLosProductos = productoDao.consultarTodos();

        System.out.println("");
        System.out.println("***** TODOS LOS PRODUCTOS *****");
        TodosLosProductos.forEach(item -> System.out.println("NombreProducto: " + item.getNombrePro()
                + ", Descripcion: " + item.getDescripcionPro()
                + ", Cantidad: " + item.getCantidadPro()
                + ", Precio: $" + item.getPrecioPro()));

        List<Producto> productosPorNombre = productoDao.consultaPorNombre("Asus");

        System.out.println("*****Busqueda Por Nombre");
        productosPorNombre.forEach(item -> System.out.println("Descripcion del producto buscado por nombre : " + item.getDescripcionPro()));
        System.out.println("*****");
        
        List<Producto> productosPorNombreCategoria = productoDao.consultaPorNombreCategoria("Celulares");
        
        System.out.println("");
        System.out.println("***** Busqueda Por Nombre de Categoria");
        productosPorNombreCategoria.forEach(item -> System.out.println("Busqueda por nombre Categoria: " + item.getNombrePro()));
        System.out.println("*****");
    }

//Metodo para insertar Producto y Categoria.
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
