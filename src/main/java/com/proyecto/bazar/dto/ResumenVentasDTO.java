package com.proyecto.bazar.dto;

public class ResumenVentasDTO {
    private int cantidadVentas;
    private double montoTotal;

    public ResumenVentasDTO() {
    }

    public ResumenVentasDTO(int cantidadVentas, double montoTotal) {
        this.cantidadVentas = cantidadVentas;
        this.montoTotal = montoTotal;
    }
    
    
}
