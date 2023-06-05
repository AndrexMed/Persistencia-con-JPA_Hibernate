package com.latam.alura.TheGioStore.modelo;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author giova
 */
@Entity
@Table(name = "items_pedido")
class ItemsDelPedido {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idPedido;
    
    private int cantidad;
    
    private BigDecimal precioUnitario; //Lo obtenemos de la Entidad Producto
    
    @ManyToOne // Muchos ItemsDelPedido a un Producto
    private Producto producto; //Clave externa que referencia al producto asociado.
    
    @ManyToOne // Muchos ItemsDelPedido a Un pedido
    private Pedido pedido; //Clave externa que referencia al pedido asociado.
    
    //Constructor default
    public ItemsDelPedido() {
    }
    
    //Constuctor personalizado
    public ItemsDelPedido(int cantidad, Pedido pedido) {
        this.cantidad = cantidad;
        this.pedido = pedido;
    }
    
    //Getters&Setters
    public Long getIdPedido() {
        return idPedido;
    }

    //public void setIdPedido(Long idPedido) {
    //    this.idPedido = idPedido;
    //}

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
}
