package com.coder.ecommerce.controllers;

import com.coder.ecommerce.service.RelojService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(path= "/api")
public class ControllerRestTemplate {
    @Autowired
    private RelojService reloj;

    @GetMapping (value= "/hora", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<?> getHora () {
        return ResponseEntity.ok(reloj.getHora());
    }
}
