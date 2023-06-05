package com.latam.alura.TheGioStore.modelo;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author giova
 */
@Table(name = "Clientes")
@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nombreCliente;
    private String dni;
    
    //Constructores   
    public Cliente(){
        
    }

    public Cliente(String nombreCliente, String dni) {
        this.nombreCliente = nombreCliente;
        this.dni = dni;
    }
    
    //Get&Seters

    public Long getIdCliente() {
        return idCliente;
    }

    //public void setIdCliente(Long idCliente) {
    //    this.idCliente = idCliente;
    //}

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
    
    
    
}
