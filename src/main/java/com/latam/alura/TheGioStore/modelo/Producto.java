package com.latam.alura.TheGioStore.modelo;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 *
 * @author giova
 */
@Entity
@Table(name="Productos") //Esto se hace ya que la clase no tiene el mismo nombre de la tabla.
public class Producto {

    private Long idProducto;
    private String nombrePro;
    private String descripcionPro;
    private int cantidadPro;
    private BigDecimal precioPro;

    
    
}
