package com.coder.ecommerce.service;

import com.coder.ecommerce.repository.RepositoryFactura;
import com.coder.ecommerce.repository.RepositoryDetalleFactura;
import com.coder.ecommerce.models.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

// Aqui se aplican toda la logica de Negocio de Factura
@Service
public class FacturaService {
    @Autowired
    private RepositoryFactura repositorio;
    @Autowired
    private RepositoryDetalleFactura repoDetalleFactura;

    public List<Factura> listar()
    {
        return this.repositorio.findAll();
    }

    public ResponseEntity<String> agregar(Factura factura){
        if (factura.getIdCliente() == null || factura.getCreadoEn() == null ||
                factura.getTotal() == null)    {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        } else
        {
            try {
                this.repositorio.save(factura);
                return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
            } catch (Exception e) {
                return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
            }
        }
    }

    public ResponseEntity<String> modificar(Long id, Factura factura){
        if (factura.getIdCliente() == null || factura.getCreadoEn() == null ||
                factura.getTotal() == null)    {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        } else {
            try {
                Factura updateFactura = this.repositorio.findById(id).get();
                updateFactura.setIdCliente(factura.getIdCliente());
                updateFactura.setCreadoEn(factura.getCreadoEn());
                updateFactura.setTotal(factura.getTotal());
                this.repositorio.save(updateFactura);
                return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
            } catch (Exception e) {
                return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
            }
        }
    }

    //Elimina la factura y todos los detalles asociados a la misma
    public ResponseEntity<String> borrar (Long id){
        try {
            Factura deleteFactura = this.repositorio.findById(id).get();
            this.repoDetalleFactura.borrarPorIdFactura(id);
            this.repositorio.delete(deleteFactura);
            return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
        } catch (Exception e) {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        }
    }

}
