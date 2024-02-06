package com.coder.ecommerce.controllers;
import com.coder.ecommerce.models.DetalleFactura;
import com.coder.ecommerce.service.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
 Controlador de los detalles de facturas, carece de metodo delete ya que debe ser
 eliminada la factura. Por lo que desde el ControllerFactura, al eliminarse la
 factura se eliminan todos los detalles de facturas ligados a esta.
 */

//Devuelve codigo 200 si esta todo OK y 409 si no pudo concretar la operacion

@RestController
@RequestMapping(path = "/detallesFacturas")
public class ControllerDetalleFactura {
    /*
    @Autowired
    private DetalleFacturaService servicioDetalleFactura;

    @GetMapping("listar")
    public List<DetalleFactura> getDetalleFactura(){
        return this.servicioDetalleFactura.listar();
    }

    @PostMapping("agregar")
    public ResponseEntity<String> agregar(@RequestBody DetalleFactura detalleFactura){
        return this.servicioDetalleFactura.agregar(detalleFactura);
    }

    @PutMapping("modificar/{id}")
    public String modificar(@PathVariable Long id, @RequestBody DetalleFactura detalleFactura){
        return "H";
        //return this.servicioDetalleFactura.modificar(id,detalleFactura);
    }*/
}
