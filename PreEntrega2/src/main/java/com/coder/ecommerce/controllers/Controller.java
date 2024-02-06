package com.coder.ecommerce.controllers;

import com.coder.ecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Controlador base, devuelve status y ayuda, etc
@RestController
public class Controller {

    @GetMapping("status")
    public ResponseEntity<String> index() {
        return ResponseEntity.status(200).body("200: Coneccion establecida :-) ");
    }

    @GetMapping("/")
    public String ayuda()
    {

        return "<b size=\"10\">API - Ayuda:</b><br><br><br><b>localhost:8080/[clientes] [productos] [facturas]</b>:" +
                "<br>/listar<br>/agregar<br>/modificar/{id}<br>/eliminar";
    }
}
