package com.coder.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CorrerAlIniciarService {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private FacturaService facturaService;
    @EventListener(ApplicationReadyEvent.class)
    public void correrAlIniciarService() {
        clienteService.inicializarClientes();
        facturaService.inicializarDatosFactura();

    }
}
