package com.latam.alura.TheGioStore.dao;

import com.latam.alura.TheGioStore.modelo.Pedido;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author giova
 */
public class PedidoDAO {

    private EntityManager conexion;

    //Constructor
    public PedidoDAO(EntityManager em) {
        this.conexion = em;
    }

    public void guardar(Pedido pedido) {
        this.conexion.persist(pedido);
    }

    public void actualizar(Pedido pedido) {
        this.conexion.merge(pedido);
    }

    public void remover(Pedido pedido) {
        this.conexion.merge(pedido);
        this.conexion.remove(pedido);
    }

    //Metodo que recibe una id, donde la buscamos en la entidad Pedido.
    public Pedido consultaPorId(Long id) {
        return this.conexion.find(Pedido.class, id);
    }

    public List<Pedido> consultarTodos() {
        String consultaJQPL = "SELECT P FROM Pedido AS P"; //Esta consulta distingue Mayus y Minus
        return this.conexion.createQuery(consultaJQPL, Pedido.class).getResultList();
    }

    public List<Pedido> consultaPorNombre(String nombreEntrante) {
        String consultaJQPL = "SELECT P FROM Pedido AS P WHERE P.nombrePro = :nombrePro";
        return this.conexion.createQuery(consultaJQPL, Pedido.class).setParameter("nombrePro", nombreEntrante).getResultList();
    }

    public List<Pedido> consultaPorNombreCategoria(String nombreCategoriaEntrante) {
        String consultaJQPL = "SELECT P FROM Pedido AS P WHERE P.categoria.nombreCategoria = :nombreCat";
        return this.conexion.createQuery(consultaJQPL, Pedido.class).setParameter("nombreCat", nombreCategoriaEntrante).getResultList();
    }

    public BigDecimal consultarPrecioPorNombrePedido(String nombreEntrante) {
        String consultaJQPL = "SELECT P.precioPro FROM Pedido P WHERE P.nombrePro = :Parametro";
        return this.conexion.createQuery(consultaJQPL, BigDecimal.class).setParameter("Parametro", nombreEntrante).getSingleResult();
    }
    
    public BigDecimal consultarTotalVendido(){
        String consulta = "SELECT MAX(P.valorTotal) FROM Pedido P";
        return this.conexion.createQuery(consulta, BigDecimal.class).getSingleResult();
    }

}
