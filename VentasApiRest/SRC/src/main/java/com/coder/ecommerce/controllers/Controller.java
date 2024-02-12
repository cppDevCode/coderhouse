package com.coder.ecommerce.controllers;

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

}
