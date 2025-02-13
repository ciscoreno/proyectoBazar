/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.bazar.service;

import com.proyecto.bazar.model.Cliente;
import com.proyecto.bazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    
    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> listaClientes = clienteRepo.findAll();
        return listaClientes;
    }

    @Override
    public Cliente getClienteById(Long id) {
        Cliente cli = clienteRepo.findById(id).orElse(null);
        return cli;
    }

    @Override
    public void saveCliente(Cliente cliente) {
       clienteRepo.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public void editCliente(Cliente cliente) {
        this.saveCliente(cliente);
    }
            
}
