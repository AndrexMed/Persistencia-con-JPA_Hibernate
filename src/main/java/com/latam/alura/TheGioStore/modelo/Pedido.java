package com.latam.alura.TheGioStore.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author giova
 */
@Table(name="Pedidos")
@Entity
public class Pedido {
    
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idPedido;
    private LocalDate fechaRegistro = LocalDate.now();
    private BigDecimal total;
    
    @ManyToOne // Un cliente tiene muchos pedidos... Aqui relacionamos Pedido con Cliente
    private Cliente cliente;
    
    @ManyToMany //Muchos Pedidos - Muchos Productos
    @JoinTable(name="items_pedidox") // Se crea tabla intermedia
    private List<Producto> productos;
    
    //Constructores
    public Pedido() {
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }
    
    //Getters y Setters

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
