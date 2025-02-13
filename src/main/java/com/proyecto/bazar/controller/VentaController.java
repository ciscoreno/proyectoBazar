package com.proyecto.bazar.controller;

import com.proyecto.bazar.model.Venta;
import com.proyecto.bazar.service.IVentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VentaController {
    
    @Autowired
    IVentaService ventaServ;
    
    @GetMapping("/ventas")
    public List<Venta> getVentas(){
        return ventaServ.getVentas();
    }
    
    @GetMapping("/ventas/{id_venta}")
    public Venta getVenta(@PathVariable Long id_venta){
        return ventaServ.getVenta(id_venta);
    }
    
    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta venta){
        ventaServ.saveVenta(venta);
        return "Venta creada";
    }
    
    @PutMapping("/ventas(editar")
    public Venta editVenta(@RequestBody Venta ven){
        ventaServ.editVenta(ven);
        return ventaServ.getVenta(ven.getCodigo_venta());
    }
    
}
