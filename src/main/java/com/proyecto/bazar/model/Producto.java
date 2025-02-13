
package com.proyecto.bazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long codigo_prod;
    private String nombre;
    private String marca;
    private double costo;
    private double cant_disponible;
    
    @ManyToMany(mappedBy ="listaProductos")
    private List<Venta> ventas;
    
    public Producto() {
    }

    public Producto(Long codigo_prod, String nombre, String marca, double costo, double cant_disponible, List<Venta> ventas) {
        this.codigo_prod = codigo_prod;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cant_disponible = cant_disponible;
        this.ventas = ventas;
    }

    
 
}
