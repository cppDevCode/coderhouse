package com.coder.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.coder.ecommerce.repository.RepositoryDetalleFactura;
import com.coder.ecommerce.models.DetalleFactura;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

// Aqui se aplican toda la logica de Negocio de Detalle de Factura
// No posee metodo delete ya que lo realiza el Servicio de Factura
@Service
public class DetalleFacturaService {
    @Autowired
    private RepositoryDetalleFactura repositorio;

    public List<DetalleFactura> listar(){
        return this.repositorio.findAll();
    }


}
