package com.coder.ecommerce.service;

import com.coder.ecommerce.models.*;
import com.coder.ecommerce.repository.RepositoryCliente;
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
    private RepositoryCliente repositoryCliente;

    @Autowired
    private RelojService relojService;

    //Carga los datos de las facturas, detalle y productos
    public void inicializarDatosFactura(){
        for (int i = 1; i <= 3; i++) {

            Long id = (long) i;

            Factura comprobante = new Factura(repositoryCliente.findById(id).get(), 125.00);
            List<DetalleFactura> df = new ArrayList<DetalleFactura>();
            String descripcion[] = {"Disco Compacto","Computadora","Heladera"};
            String codigo[] = {"144777840","11457752","478745512"};
            List<Producto> listaProductos = new ArrayList<Producto>();
            for (int a = 0; a < 3; a++){
                Producto producto = new Producto(descripcion[a],codigo[a],5,125.00);
                repositoryProducto.save(producto);
                listaProductos.add(producto);
            }


            for (int j = 1; j <= 3; j++) {
                Double precio = 150.00 / j;

                List<Producto> aux = new ArrayList<Producto>();
                for (Producto p:listaProductos){
                    DetalleFactura detalle = new DetalleFactura(1,  precio, comprobante);
                    Producto pd = new Producto();
                    pd.setPrecio(p.getPrecio());
                    pd.setStock(p.getStock());
                    pd.setCodigo(p.getCodigo());
                    pd.setDescripcion(p.getDescripcion());
                    pd.setIdProducto(p.getIdProducto());
                    detalle.setProducto(pd);
                    df.add(detalle);
                }


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
                linea.setCantidad(producto.getCantidad());
                ProductoDTO productoDTO = new ProductoDTO();
                productoDTO.setCodigo(producto.getProducto().getCodigo());
                productoDTO.setPrecio(producto.getProducto().getPrecio());
                productoDTO.setDescripcion(producto.getProducto().getDescripcion());
                linea.setProducto(productoDTO);
                linea.setPrecio(producto.getSubtotal());
                dtoDetalle.add(linea);

        }
        dto.setDetalleFactura(dtoDetalle);
        dto.setCreadoEn(factura.getCreadoEn());
        dto.setTotal(factura.getTotal());
        ClienteDTO clienteDTO = new ClienteDTO();
        Cliente cliente = new Cliente();
        cliente = factura.getCliente();
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setDni(cliente.getDni());
        clienteDTO.setNombre(cliente.getNombre());
        dto.setCliente(clienteDTO);
        return dto;
    }
//MEJORAR, CREAR OBJETOS SI NO EXISTEN EN LA BBDD
    public ResponseEntity<String> agregar(Factura factura){

        if (factura.getCliente() == null ||
                factura.getTotal() == null)    {

            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        } else
        {
            try {
                Factura facturaAGuardar = new Factura();
                repositoryCliente.save(factura.getCliente());
                facturaAGuardar.setCliente(factura.getCliente());
                String fechaString = relojService.getDato();
                LocalDateTime fecha = LocalDateTime.parse(fechaString);
                facturaAGuardar.setCreadoEn(fecha);
                facturaAGuardar.setId(factura.getId());
                facturaAGuardar.setTotal(factura.getTotal());
                List<DetalleFactura> lineas = new ArrayList<>();
                for (DetalleFactura linea: factura.getDetalleFactura()){
                    linea.setFactura(facturaAGuardar);
                    lineas.add(linea);
                    repositoryProducto.save(linea.getProducto());
                }
                facturaAGuardar.setDetalleFactura(lineas);


                this.repositorio.save(facturaAGuardar);
                return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
            } catch (Exception e) {
                return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
            }
        }
    }

    ///TENGO QUE ACOMODAR MODIFICAR
    public ResponseEntity<String> modificar(Long id, Factura factura){
        if (factura.getCliente() == null || factura.getTotal() == null)    {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        } else {
            try {
                Factura updateFactura = this.repositorio.findById(id).get();
                updateFactura.setCliente(factura.getCliente());
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
