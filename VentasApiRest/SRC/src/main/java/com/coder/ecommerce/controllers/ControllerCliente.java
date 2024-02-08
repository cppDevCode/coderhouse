package com.coder.ecommerce.controllers;

import com.coder.ecommerce.models.Cliente;
import com.coder.ecommerce.models.ClienteDTO;
import com.coder.ecommerce.models.Factura;
import com.coder.ecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Devuelve codigo 200 si esta todo OK y 409 si no pudo concretar la operacion

@RestController
@RequestMapping(path = "api/clientes")
public class ControllerCliente {
    @Autowired
    private ClienteService servicioCliente;

    @GetMapping("listar")
    public List<ClienteDTO> getCliente(){
        return this.servicioCliente.listar();
    }

    @PostMapping("agregar")
    public ResponseEntity<String> agregar(@RequestBody Cliente cliente){
        return (this.servicioCliente.grabar(cliente));
    }

    @PutMapping("modificar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Long id, @RequestBody Cliente cliente){
       return(this.servicioCliente.actualizar(id,cliente));
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        return(this.servicioCliente.borrar(id));
    }
}
