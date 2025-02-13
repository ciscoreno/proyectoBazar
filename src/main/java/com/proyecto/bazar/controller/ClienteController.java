
package com.proyecto.bazar.controller;

import com.proyecto.bazar.model.Cliente;
import com.proyecto.bazar.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    IClienteService clienteServ;
    
    @GetMapping("/cliente")
    public List<Cliente> getClientes() {
        return clienteServ.getClientes();
    }
    
    @GetMapping("/cliente/{id_cliente}")
    public Cliente getDueño(@PathVariable Long id_cliente){
        return clienteServ.getClienteById(id_cliente);
    }
    
    @PostMapping("/cliente/crear")
    public String saveCliente(@RequestBody Cliente cliente){
        clienteServ.saveCliente(cliente);
        return "Cliente creado";    
    }
    
    @PutMapping("/cliente/editar")
    public Cliente editCliente(@RequestBody Cliente cliente){
        clienteServ.editCliente(cliente);
        return clienteServ.getClienteById(cliente.getId_cliente());
    }
    
}
