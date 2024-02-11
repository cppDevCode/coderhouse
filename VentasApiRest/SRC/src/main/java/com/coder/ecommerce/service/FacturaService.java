package com.coder.ecommerce.service;

import com.coder.ecommerce.models.*;
import com.coder.ecommerce.repository.RepositoryCliente;
import com.coder.ecommerce.repository.RepositoryFactura;
import com.coder.ecommerce.repository.RepositoryProducto;
import org.json.JSONObject;
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
        String descripcion[] = {"Disco Compacto","Computadora","Heladera"};
        Double precios[] = {100.50,99.99,987.57};
        Double total = 0.00;
        int cantidad = 1;
        String codigo[] = {"144777840","11457752","478745512"};

        for (int a = 0; a < 3; a++){
            Producto producto = new Producto(descripcion[a],codigo[a],5,precios[a]);
            repositoryProducto.save(producto);

        }

        for (int i = 1; i <= 3; i++) {
            List<DetalleFactura> df = new ArrayList<DetalleFactura>();
            Long id = (long) i;
            int cantidadProductos = 0;
            Factura comprobante = new Factura(repositoryCliente.findById(id).get(), total);
            List<Producto> aux = new ArrayList<Producto>();
            List<Producto> listaProductos = new ArrayList<Producto>();
            Random aleatorioInt = new Random();
            int topeProductos = aleatorioInt.nextInt((5-1)+1) + 1;
            for (int x = 0; x < topeProductos; x++) {
                Producto producto = repositoryProducto.findById(aleatorioInt.nextLong((2-1)+1)+1).get();
                listaProductos.add(producto);
            }
            for (Producto p:listaProductos){
                DetalleFactura detalle = new DetalleFactura(cantidad,  0.00, comprobante);
                Producto pd = new Producto();
                cantidadProductos += cantidad;
                pd.setPrecio(p.getPrecio() * cantidad);
                total += pd.getPrecio();
                pd.setStock(p.getStock());
                pd.setCodigo(p.getCodigo());
                pd.setDescripcion(p.getDescripcion());
                pd.setIdProducto(p.getIdProducto());
                detalle.setProducto(pd);
                detalle.setPrecioProducto(pd.getPrecio());
                df.add(detalle);
            }
            comprobante.setCantidadTotalProductosVendidos(cantidadProductos);
            comprobante.setTotal(total);
            total = 0.00;



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
                productoDTO.setDescripcion(producto.getProducto().getDescripcion());
                linea.setProducto(productoDTO);
                linea.setPrecioProducto(producto.getPrecioProducto());
                dtoDetalle.add(linea);

        }
        dto.setCantidadTotalProductosVendidos(factura.getCantidadTotalProductosVendidos());
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

    public ResponseEntity<String> agregar(Factura factura){

        if (factura.getCliente() == null)    {

            return ResponseEntity.status(409).body("Error Code 409\n Debe facilitar un numero de Cliente ID\n");
        } else
        {
            try {
                Long idCliente = factura.getCliente().getIdCliente();
                if (repositoryCliente.existsById(idCliente)) {
                    Factura facturaAGuardar = new Factura();
                    facturaAGuardar.setCliente(repositoryCliente.findById(idCliente).get());
                    String fechaString = relojService.getDato();
                    LocalDateTime fecha = LocalDateTime.parse(fechaString);
                    facturaAGuardar.setCreadoEn(fecha);
                    facturaAGuardar.setId(factura.getId());
                    facturaAGuardar.setTotal(factura.getTotal());
                    List<DetalleFactura> lineas = new ArrayList<>();
                    DetalleFactura dfAux = new DetalleFactura();
                    Double totalFactura = 0.00;
                    int cantidadProductos = 0;
                    for (DetalleFactura linea : factura.getDetalleFactura()) {
                        Producto producto = new Producto();
                        Long idProducto = linea.getProducto().getIdProducto();
                        if ( repositoryProducto.existsById(idProducto) ) {
                            producto = repositoryProducto.findById(idProducto).get();
                            dfAux.setFactura(facturaAGuardar);
                            dfAux.setPrecioProducto(producto.getPrecio());
                            totalFactura += producto.getPrecio();
                            if (producto.getStock() >= linea.getCantidad()) {
                                dfAux.setCantidad(linea.getCantidad());
                                producto.setStock(producto.getStock() - linea.getCantidad());
                                repositoryProducto.save(producto);
                                cantidadProductos += linea.getCantidad();
                                dfAux.setProducto(producto);
                                lineas.add(dfAux);
                            } else {
                                return ResponseEntity.status(409).body("Error Code: 409\n No se puede vender " +
                                        linea.getCantidad() + " unidades, por que supera el stock disponible de " +
                                        producto.getStock() + " unidades");
                            }
                        } else {
                            return ResponseEntity.status(409).body("Error Code: 409\nNo existe Producto con ID #" + idProducto);
                        }
                    }
                    facturaAGuardar.setTotal(totalFactura);
                    facturaAGuardar.setCantidadTotalProductosVendidos(cantidadProductos);
                    facturaAGuardar.setDetalleFactura(lineas);
                    this.repositorio.save(facturaAGuardar);
                    return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria: Factura agregada a la BBDD!\n");
                }
                else {
                    return ResponseEntity.status(409).body("Error Code: 409\nNo existe Cliente con ID #" + idCliente
                        + "\n");
                }
            } catch (Exception e) {
                return ResponseEntity.status(409).body("Error Code: 409\nLa operacion no se pudo realizar, verificar!\n");
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
            return ResponseEntity.status(200).body("200:\n Factura ID #" + id + " Eliminada!\n");
        } catch (Exception e) {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        }
    }

}
