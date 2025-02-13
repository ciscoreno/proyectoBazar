/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.bazar.service;

import com.proyecto.bazar.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    public List<Cliente> getClientes();
    
    public Cliente getClienteById(Long id);
    
    public void saveCliente(Cliente cliente);
    
    public void deleteCliente(Long id);
    
    public void editCliente(Cliente cliente);
    
    
}
