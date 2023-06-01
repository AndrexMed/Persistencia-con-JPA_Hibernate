package com.latam.alura.TheGioStore.modelo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author giova
 */
@Entity
@Table(name = "Productos") //Esto se hace cuando la clase no tiene el mismo nombre de la tabla.
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Configurando ID para representar llave primaria de la tabla

    @Column(name = "idProducto")// Esto se hace cuando los nombres de las tablas no coiciden con los de this.
    private Long idPro;

    @Column(name = "nombreProducto")
    private String nombrePro;

    @Column(name = "descripcionProducto")
    private String descripcionPro;

    @Column(name = "cantidadProducto")
    private int cantidadPro;

    @Column(name = "precioProducto")
    private BigDecimal precioPro;

    public Long getIdProducto() {
        return idPro;
    }

    public void setIdProducto(Long idProducto) {
        this.idPro = idProducto;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getDescripcionPro() {
        return descripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) {
        this.descripcionPro = descripcionPro;
    }

    public int getCantidadPro() {
        return cantidadPro;
    }

    public void setCantidadPro(int cantidadPro) {
        this.cantidadPro = cantidadPro;
    }

    public BigDecimal getPrecioPro() {
        return precioPro;
    }

    public void setPrecioPro(BigDecimal precioPro) {
        this.precioPro = precioPro;
    }

}
