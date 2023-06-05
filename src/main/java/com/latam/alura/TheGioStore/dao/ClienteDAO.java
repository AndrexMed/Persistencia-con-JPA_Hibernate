package com.latam.alura.TheGioStore.dao;

import com.latam.alura.TheGioStore.modelo.Cliente;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author giova
 */
public class ClienteDAO {

    private EntityManager conexion;

    //Constructor
    public ClienteDAO(EntityManager em) {
        this.conexion = em;
    }

    public void guardar(Cliente cliente) {
        this.conexion.persist(cliente);
    }

    public void actualizar(Cliente cliente) {
        this.conexion.merge(cliente);
    }

    public void remover(Cliente cliente) {
        this.conexion.merge(cliente);
        this.conexion.remove(cliente);
    }

    //Metodo que recibe una id, donde la buscamos en la entidad Cliente.
    public Cliente consultaPorId(Long id) {
        return this.conexion.find(Cliente.class, id);
    }

    public List<Cliente> consultarTodos() {
        String consultaJQPL = "SELECT P FROM Cliente AS P"; //Esta consulta distingue Mayus y Minus
        return this.conexion.createQuery(consultaJQPL, Cliente.class).getResultList();
    }

    public List<Cliente> consultaPorNombre(String nombreEntrante) {
        String consultaJQPL = "SELECT P FROM Cliente AS P WHERE P.nombrePro = :nombrePro";
        return this.conexion.createQuery(consultaJQPL, Cliente.class).setParameter("nombrePro", nombreEntrante).getResultList();
    }

    public List<Cliente> consultaPorNombreCategoria(String nombreCategoriaEntrante) {
        String consultaJQPL = "SELECT P FROM Cliente AS P WHERE P.categoria.nombreCategoria = :nombreCat";
        return this.conexion.createQuery(consultaJQPL, Cliente.class).setParameter("nombreCat", nombreCategoriaEntrante).getResultList();
    }

    public BigDecimal consultarPrecioPorNombreCliente(String nombreEntrante) {
        String consultaJQPL = "SELECT P.precioPro FROM Cliente P WHERE P.nombrePro = :Parametro";
        return this.conexion.createQuery(consultaJQPL, BigDecimal.class).setParameter("Parametro", nombreEntrante).getSingleResult();
    }

}
