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

    public ResponseEntity<String> agregar(DetalleFactura detalleFactura){
        /*
        if (detalleFactura.getIdFactura() == null || detalleFactura.getIdProducto() == null ||
                detalleFactura.getPrecio() == null )    {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        } else
        {
            try {
                this.repositorio.save(detalleFactura);
                return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
            } catch (Exception e) {*/
                return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
            /*}
        }*/
    }

    public ResponseEntity<String> modificar(Long id, DetalleFactura detalleFactura){
        /*
        if (detalleFactura.getIdFactura() == null || detalleFactura.getIdProducto() == null ||
                detalleFactura.getPrecio() == null )    {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        } else {
            try {
                DetalleFactura updateDetalleFactura = this.repositorio.findById(id).get();
                updateDetalleFactura.setIdFactura(detalleFactura.getIdFactura());
                updateDetalleFactura.setCantidad(detalleFactura.getCantidad());
                updateDetalleFactura.setIdProducto(detalleFactura.getIdProducto());
                updateDetalleFactura.setPrecio(detalleFactura.getPrecio());
                this.repositorio.save(updateDetalleFactura);
                return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
            } catch (Exception e) {*/
                return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
            /*}
        }*/
    }

}
