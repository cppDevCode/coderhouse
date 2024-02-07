package com.coder.ClienteApiRest.Controller;

import com.coder.ClienteApiRest.Model.Cliente;
import com.coder.ClienteApiRest.Model.ClienteOutput;
import com.coder.ClienteApiRest.Service.ClienteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService servicioCliente;
    /*
    * localhost:http://localhost:8080/api/clientes/listar
    * Lista todos los clientes de la base de datos
    *
    * http://localhost:8080/api/clientes/init
    *
    * Carga datos a la base de datos
    *
    * http://localhost:8080/api/clientes/get/id={id}
    *
    * Retorna el cliente con el ID indicado
    * */
    @GetMapping(value = "listar",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> listar(){
        List<ClienteOutput> resultado = servicioCliente.listar();
        if ( resultado.isEmpty() ) {
            System.out.println("No se hallaron datos en la base!");
            return ResponseEntity.status(409).body("No se hallaron datos en la data base!");
        } else {
            return ResponseEntity.status(200).body(resultado);
        }
    }

    @GetMapping("init")
    public ResponseEntity<String> inicializar(){
        return servicioCliente.inicializarDatos();
    }

    @GetMapping (value = "get/id={id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> devolverID(@PathVariable(name="id") Long id){
        ClienteOutput resultado = this.servicioCliente.tomarByID(id);
        if (resultado.getAnios() != -1 ) {
            return ResponseEntity.status(200).body(resultado);
        } else {
            return ResponseEntity.status(409).body("ID Inexistente");
        }

    }


}
