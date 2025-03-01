
package com.proyecto.bazar.dto;

public class MayorVentaDTO {
    private Long codigoVenta;
    private double total;
    private int cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public MayorVentaDTO() {
    }
    
    public MayorVentaDTO(Long codigoVenta, double total, int cantidadProductos, String nombreCliente, String apellidoCliente) {
        this.codigoVenta = codigoVenta;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }

}
