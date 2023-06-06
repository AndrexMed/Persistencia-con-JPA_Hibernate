package com.latam.alura.TheGioStore.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author giova
 */
@NamedQuery(name = "Producto.consultaDePrecio" , query = "SELECT P.precioPro FROM Producto P WHERE P.nombrePro = :Parametro")
@Entity
//@Table(name = "Productos") //Esto se hace cuando la clase no tiene el mismo nombre de la tabla.
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Configurando ID para representar llave primaria de la tabla

    //@Column(name = "idProducto")// Esto se hace cuando los nombres de las tablas no coiciden con los de de la clase.
    private Long idPro;

    //@Column(name = "nombreProducto")
    private String nombrePro;

    //@Column(name = "descripcionProducto")
    private String descripcionPro;

    //@Column(name = "cantidadProducto")
    private int cantidadPro;

    //@Column(name = "precioProducto")
    private BigDecimal precioPro;

    private LocalDate fechaRegistro = LocalDate.now(); //Esto manda como parametro a la consulta Insert, la fecha en que se genera el registro(consulta)

    //@Enumerated(EnumType.STRING) //Conversion a String, ya que me retorna int
    @ManyToOne    //Creamos la relacion entre Tabla Productos y Categorias
    private Categoria categoria;

    //Constructor
    public Producto() {
        
    }

    //Constructor
    public Producto(String nombrePro, String descripcionPro, int cantidadPro, BigDecimal precioPro, Categoria categoria) {
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
        this.cantidadPro = cantidadPro;
        this.precioPro = precioPro;
        this.categoria = categoria;
    }

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
