package com.proyecto.bazar.service;

import com.proyecto.bazar.dto.ResumenVentasDTO;
import com.proyecto.bazar.model.Producto;
import com.proyecto.bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    
    public List<Venta> getVentas();
    
    public Venta getVenta(Long idVenta);
    
    public List<Producto> getProductosDeVenta(Long idVenta);
    
    public ResumenVentasDTO getResumenVentasEnFecha(LocalDate fecha_venta);
    
    public void saveVenta(Venta venta);
    
    public void deleteVenta(Long id);
    
    public void editVenta(Venta venta);

    
}
