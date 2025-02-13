/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.bazar.service;

import com.proyecto.bazar.model.Venta;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IVentaService {
    
    public List<Venta> getVentas();
    
    public Venta getVenta(Long idVenta);
    
    public void saveVenta(Venta venta);
    
    public void deleteVenta(Long id);
    
    public void editVenta(Venta venta);
    
}
