package com.latam.alura.TheGioStore.vo;

import java.time.LocalDate;

/**
 *
 * @author giova
 */
public class RelatorioDeVentas {

    private String nombreDelProducto;
    private Long CantidadDelProducto;
    private LocalDate fechaUltimaVenta;

    public RelatorioDeVentas(String nombreDelProducto, Long CantidadDelProducto, LocalDate fechaUltimaVenta) {
        this.nombreDelProducto = nombreDelProducto;
        this.CantidadDelProducto = CantidadDelProducto;
        this.fechaUltimaVenta = fechaUltimaVenta;
    }

    public String getNombreDelProducto() {
        return nombreDelProducto;
    }

    public void setNombreDelProducto(String nombreDelProducto) {
        this.nombreDelProducto = nombreDelProducto;
    }

    public Long getCantidadDelProducto() {
        return CantidadDelProducto;
    }

    public void setCantidadDelProducto(Long CantidadDelProducto) {
        this.CantidadDelProducto = CantidadDelProducto;
    }

    public LocalDate getFechaUltimaVenta() {
        return fechaUltimaVenta;
    }

    public void setFechaUltimaVenta(LocalDate fechaUltimaVenta) {
        this.fechaUltimaVenta = fechaUltimaVenta;
    }

    @Override
    public String toString() {
        return  "\n"
                + "Imprimiendo desde RelatorioDeVentas *****\n"
                + "Nombre del Producto = " + nombreDelProducto
                + "\nCantidadDelProducto = " + CantidadDelProducto
                + "\nfechaUltimaVenta = " + fechaUltimaVenta + '}';
    }

}
