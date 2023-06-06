package com.latam.alura.TheGioStore.tests;

import com.latam.alura.TheGioStore.dao.CategoriaDAO;
import com.latam.alura.TheGioStore.dao.ClienteDAO;
import com.latam.alura.TheGioStore.dao.PedidoDAO;
import com.latam.alura.TheGioStore.dao.ProductoDAO;
import com.latam.alura.TheGioStore.modelo.Categoria;
import com.latam.alura.TheGioStore.modelo.Cliente;
import com.latam.alura.TheGioStore.modelo.ItemsDelPedido;
import com.latam.alura.TheGioStore.modelo.Pedido;
import com.latam.alura.TheGioStore.modelo.Producto;
import com.latam.alura.TheGioStore.utils.JPAUtils;
import com.latam.alura.TheGioStore.vo.RelatorioDeVentas;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author giova
 */
public class RegistroDePedido {

    public static void main(String[] args) {
        registrarProducto();

        EntityManager conexion = JPAUtils.recuperarConexion();

        ProductoDAO productoDao = new ProductoDAO(conexion);
        Producto producto = productoDao.consultaPorId(1l);

        ClienteDAO clienteDao = new ClienteDAO(conexion);
        PedidoDAO pedidoDao = new PedidoDAO(conexion);

        Cliente cliente1 = new Cliente("Andres", "5678");
        Pedido pedido1 = new Pedido(cliente1);
        pedido1.agregarItems(new ItemsDelPedido(5, producto, pedido1));

        conexion.getTransaction().begin();

        clienteDao.guardar(cliente1);
        pedidoDao.guardar(pedido1);

        conexion.getTransaction().commit();

        BigDecimal valorTotalVendido = pedidoDao.consultarTotalVendido();
        System.out.println("Valor Total Ventas : " + valorTotalVendido);

        /*Forma1
        List<Object[]> relatorio = pedidoDao.relatorioDeVentas();
        
        System.out.println("Relatorio de Ventas *****");
        for (Object[] objects : relatorio) {
            System.out.println(objects[0]);
            System.out.println(objects[1]);
            System.out.println(objects[2]);
        }*/
        
        //Forma 2
        List<RelatorioDeVentas> relatorio = pedidoDao.relatorioDeVentasVO();
        
        relatorio.forEach(System.out::println);

    }

    private static void registrarProducto() {
        Categoria categoria = new Categoria("Computadores");

        Producto computador = new Producto("Asus Vivo Book",
                "Color Azul",
                10,
                new BigDecimal("1000"),
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
