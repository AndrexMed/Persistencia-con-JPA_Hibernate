package com.latam.alura.TheGioStore.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author giova
 */
@Entity
@Table(name="Productos")
public class Producto {

    private Long id;
    private String nombre;
    private String descripcion;
    private int cantidad;

    
    
}
