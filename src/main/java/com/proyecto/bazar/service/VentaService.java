
package com.proyecto.bazar.service;

import com.proyecto.bazar.model.Venta;
import com.proyecto.bazar.repository.IVentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {
    
    @Autowired
    private IVentaRepository ventaRepo;
    
    @Override
    public List<Venta> getVentas() {
        List<Venta> listaVentas = ventaRepo.findAll();
        return listaVentas;
    }

    @Override
    public Venta getVenta(Long idVenta) {
        Venta ven = ventaRepo.findById(idVenta).orElse(null);
        return ven;
    }

    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);
    }
    
}
