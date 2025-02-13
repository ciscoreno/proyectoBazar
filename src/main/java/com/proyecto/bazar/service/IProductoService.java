
package com.proyecto.bazar.service;

import com.proyecto.bazar.model.Producto;
import java.util.List;

public interface IProductoService {
    
    public List<Producto> getProductos();
    
    public Producto getProducto(Long id);
 
    public void saveProducto(Producto producto);
    
    public void deleteProducto(Long id);
    
    public void editProducto(Producto producto);
    
}
