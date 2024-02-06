package com.coder.ecommerce.service;

import com.coder.ecommerce.models.*;
import com.coder.ecommerce.repository.RepositoryFactura;
import com.coder.ecommerce.repository.RepositoryProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

// Aqui se aplican toda la logica de Negocio de Factura
@Service
public class FacturaService {
    @Autowired
    private RepositoryFactura repositorio;

    @Autowired
    private RepositoryProducto repositoryProducto;

    @Autowired
    private RelojService relojService;

    //Carga los datos de las facturas, detalle y productos
    public void inicializarDatosFactura(){
        for (int i = 1; i <= 3; i++) {
            Factura comprobante = new Factura(Long.valueOf(i), 125.00);
            List<DetalleFactura> df = new ArrayList<DetalleFactura>();
            String descripcion[] = {"Disco Compacto","Computadora","Heladera"};
            String codigo[] = {"144777840","11457752","478745512"};
            repositoryProducto.save(new Producto(descripcion[i-1],codigo[i-1],i,125.00));
            for (int j = 1; j <= 3; j++) {
                Double precio = 150.00 / j;
                df.add(new DetalleFactura(1, Long.valueOf(j), precio, comprobante));

            }

            comprobante.setDetalleFactura(df);
            repositorio.save(comprobante);
        }
    }
    public List<FacturaDTO> listar()
    {
        List<FacturaDTO> facturaAListar = new ArrayList<FacturaDTO>();
        for (Factura comprobante:this.repositorio.findAll()){
                facturaAListar.add(crearFactura(comprobante));
        }
        return facturaAListar;
    }

    private FacturaDTO crearFactura (Factura factura){
        FacturaDTO dto = new FacturaDTO();
        dto.setId(factura.getId());

        List<DetalleFacturaDTO> dtoDetalle = new ArrayList<DetalleFacturaDTO>();
        for (DetalleFactura producto: factura.getDetalleFactura()){
                DetalleFacturaDTO linea = new DetalleFacturaDTO();
                linea.setId(producto.getId());
                linea.setCantidad(producto.getCantidad());
                linea.setIdProducto(producto.getIdProducto());
                linea.setPrecio(producto.getPrecio());
                dtoDetalle.add(linea);
        }
        dto.setDetalleFactura(dtoDetalle);
        dto.setCreadoEn(factura.getCreadoEn());
        dto.setTotal(factura.getTotal());
        dto.setIdCliente(factura.getIdCliente());
        return dto;
    }

    public ResponseEntity<String> agregar(Factura factura){
        if (factura.getIdCliente() == null || factura.getCreadoEn() == null ||
                factura.getTotal() == null)    {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        } else
        {
            try {
                Factura facturaAGuardar = new Factura();
                facturaAGuardar.setIdCliente(factura.getIdCliente());
                String fechaString = relojService.getDato();
                LocalDateTime fecha = LocalDateTime.parse(fechaString);
                facturaAGuardar.setCreadoEn(fecha);
                facturaAGuardar.setId(factura.getId());
                facturaAGuardar.setTotal(factura.getTotal());
                List<DetalleFactura> lineas = new ArrayList<>();
                for (DetalleFactura linea: factura.getDetalleFactura()){
                    linea.setFactura(facturaAGuardar);
                    lineas.add(linea);
                }
                facturaAGuardar.setDetalleFactura(lineas);


                this.repositorio.save(facturaAGuardar);
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
            //this.repoDetalleFactura.borrarPorIdFactura(id);
            this.repositorio.delete(deleteFactura);
            return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
        } catch (Exception e) {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        }
    }

}
