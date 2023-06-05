package com.latam.alura.TheGioStore.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    private BigDecimal valorTotal = new BigDecimal(0);
    
    @ManyToOne // Muchos Pedidos a Un Cliente... Aqui relacionamos Pedido con Cliente
    private Cliente cliente;
    
    @OneToMany(mappedBy = "pedidoFK", cascade = CascadeType.ALL) // Tipo de Relacion : Un Pedido a Muchos "ItemsDelPedido", Con el mapped, referenciamos exactamente con la tabla ItemsDelPedido
    private List<ItemsDelPedido> elementos = new ArrayList<>(); //Lista vacia
    
    //Constructores
    public Pedido() {
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void agregarItems(ItemsDelPedido item){ //Agregamos los items dentro de la lista "elementos"
        item.setPedido(this);
        this.elementos.add(item);
        this.valorTotal = this.valorTotal.add(item.getValorTotal());
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
        return valorTotal;
    }

    public void setTotal(BigDecimal total) {
        this.valorTotal = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
