package com.coder.ecommerce.controllers;

import com.coder.ecommerce.models.Producto;
import com.coder.ecommerce.models.ProductoDTO;
import com.coder.ecommerce.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Devuelve codigo 200 si esta todo OK y 409 si no pudo concretar la operacion

@RestController
@RequestMapping(path = "api/productos")
public class ControllerProducto {
    @Autowired
    private ProductoService servicioProducto;

    @Operation(summary = "Lista productos", description = "Devuelve un JSON con los productos existentes en la BBDD")
    @GetMapping("listar")
    public List<ProductoDTO> listar(){
        return this.servicioProducto.listar();
    }

    @PostMapping("agregar")
    @Operation(summary = "Agrega un producto", description = "Agrega un producto a la BBDD")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operacion sastifactoria, producto agregado a la BBDD"),
            @ApiResponse(responseCode = "409", description = "La operacion no se pudo realizar, verificar!",content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Producto.class))})})
    public ResponseEntity<String> agregar(@RequestBody Producto producto){
        return this.servicioProducto.grabar(producto);
    }

    @Operation(summary = "Modifica un producto")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operacion sastifactoria, producto modificado en la BBDD"),
            @ApiResponse(responseCode = "409", description = "Error Code: 409 La operacion no se pudo realizar, verificar!",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Producto.class))})})
    @PutMapping("modificar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Long id, @RequestBody Producto producto){
        return this.servicioProducto.actualizar(id,producto);
    }


    @Operation(summary = "Modifica Stock de un producto")
    @PatchMapping("stock")
    public ResponseEntity<String> actualizarStock(@Validated @RequestParam(name = "id") Long id,@Validated @RequestParam(name = "ventas")  int ventas ){
        return this.servicioProducto.actualizarStock(id, ventas);
    }

    @Operation(summary = "Elimina un producto")
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
       return this.servicioProducto.borrar(id);
    }
}
