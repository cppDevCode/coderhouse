package com.coder.ecommerce.controllers;
import com.coder.ecommerce.models.Producto;
import com.coder.ecommerce.models.ProductoDTO;
import com.coder.ecommerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//Devuelve codigo 200 si esta todo OK y 409 si no pudo concretar la operacion

@RestController
@RequestMapping(path = "api/productos")
public class ControllerProducto {
    @Autowired
    private ProductoService servicioProducto;

    @GetMapping("listar")
    public List<ProductoDTO> listar(){
        return this.servicioProducto.listar();
    }

    @PostMapping("agregar")
    public ResponseEntity<String> agregar(@RequestBody Producto producto){
        return this.servicioProducto.grabar(producto);
    }

    @PutMapping("modificar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Long id, @RequestBody Producto producto){
        return this.servicioProducto.actualizar(id,producto);
    }


    @PatchMapping("stock")
    public ResponseEntity<String> actualizarStock(@Validated @RequestParam(name = "id") Long id,@Validated @RequestParam(name = "ventas")  int ventas ){
        return this.servicioProducto.actualizarStock(id, ventas);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
       return this.servicioProducto.borrar(id);
    }
}
