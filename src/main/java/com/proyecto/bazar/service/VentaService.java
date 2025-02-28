
package com.proyecto.bazar.service;

import com.proyecto.bazar.dto.MayorVentaDTO;
import com.proyecto.bazar.dto.ResumenVentasDTO;
import com.proyecto.bazar.model.Cliente;
import com.proyecto.bazar.model.Producto;
import com.proyecto.bazar.model.Venta;
import com.proyecto.bazar.repository.IVentaRepository;
import java.time.LocalDate;
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
    
     // Obtiene los productos de una determinada venta
    @Override
    public List<Producto> getProductosDeVenta(Long id_venta){
        Venta venta = ventaRepo.findById(id_venta).orElse(null);
        return venta.getListaProductos();
    }
    
    @Override
    public ResumenVentasDTO getResumenVentasEnFecha(LocalDate fecha){
        List<Venta> ventasDelDia = ventaRepo.findByFechaVenta(fecha);
        
        int cantVentas = ventasDelDia.size();
        double sumaMontos = 0;
        
        for(Venta venta : ventasDelDia){
            sumaMontos += venta.getTotal();     
        }
        
        return new ResumenVentasDTO(cantVentas, sumaMontos);    
    }
    
    public MayorVentaDTO getVentaMayor(){
        List<Venta> ventas = ventaRepo.findAll();
        
        Venta mayorVenta = ventas.get(0);
        for(Venta venta : ventas){
            if(venta.getTotal() > mayorVenta.getTotal()){
                mayorVenta = venta;
            }
        }
        
        Cliente cliente = mayorVenta.getCliente();
        
        MayorVentaDTO infoVenta = new MayorVentaDTO(
            mayorVenta.getCodigo_venta() ,
            mayorVenta.getTotal(),
            mayorVenta.getListaProductos().size(),
            cliente.getNombre(),
            cliente.getApellido()
        );
        
        return infoVenta;
        
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
