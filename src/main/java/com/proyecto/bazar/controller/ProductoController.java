
package com.proyecto.bazar.controller;

import com.proyecto.bazar.model.Producto;
import com.proyecto.bazar.service.IProductoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    IProductoService prodServ;
    
    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return prodServ.getProductos();
    }
    
    @GetMapping("/productos/{id_producto}")
    public Producto getProducto(@PathVariable Long id_producto){
        return prodServ.getProducto(id_producto);
    }
    
    @GetMapping("/productos/sin_stock")
    public List<Producto> getProductosSinStock() {
        List<Producto> productos = prodServ.getProductos();
        List<Producto> productosSinStock = new ArrayList<>();
        
        for (Producto producto : productos) {
            if (producto.getCant_disponible() <= 5) {
                productosSinStock.add(producto);
            }   
        }
        
        return productosSinStock;
    }

    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto prod){
        prodServ.saveProducto(prod);    
        return "Producto creado";
    }
    
    @PutMapping("/productos/editar")
    public Producto editProducto(@RequestBody Producto prod){
        prodServ.editProducto(prod);
        return prodServ.getProducto(prod.getCodigo_prod());
    }
    
}
