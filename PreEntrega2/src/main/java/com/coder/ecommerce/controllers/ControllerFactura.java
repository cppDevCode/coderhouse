package com.coder.ecommerce.controllers;

import com.coder.ecommerce.models.Factura;
import com.coder.ecommerce.models.FacturaDTO;
import com.coder.ecommerce.repository.RepositoryFactura;
import org.springframework.beans.factory.annotation.Autowired;
import com.coder.ecommerce.service.FacturaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

//Devuelve codigo 200 si esta todo OK y 409 si no pudo concretar la operacion

@RestController
@RequestMapping(path = "/facturas")
public class ControllerFactura {
    @Autowired
    private FacturaService facturaServicio;

    @Autowired
    private RepositoryFactura repositoryFactura;
  //  @Autowired
   // private RepositoryDetalleFactura repoDetalleFactura;

    @GetMapping("listar")
    public List<FacturaDTO> getFactura(){
        return this.facturaServicio.listar();
    }

    @PostMapping("agregar")
    public ResponseEntity<String> agregar(@RequestBody Factura factura){
       return this.facturaServicio.agregar(factura);
    }

    @PutMapping("modificar/{id}")
    public ResponseEntity<String> modificar(@PathVariable Long id, @RequestBody Factura factura){
        return this.facturaServicio.modificar(id,factura);
    }

    // Elimina la factura y todos los detalle ligados a esta
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        return this.facturaServicio.borrar(id);
    }
}
