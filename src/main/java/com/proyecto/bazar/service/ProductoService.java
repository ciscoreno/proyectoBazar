
package com.proyecto.bazar.service;

import com.proyecto.bazar.model.Producto;
import com.proyecto.bazar.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepo;
    
    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = productoRepo.findAll();
        return listaProductos;
    }

    @Override
    public Producto getProducto(Long id) {
        Producto prod = productoRepo.findById(id).orElse(null);
        return prod;
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepo.deleteById(id);
    }

    @Override
    public void editProducto(Producto producto) {
        this.saveProducto(producto);
    }
    
}
