package com.coder.ecommerce.service;

import com.coder.ecommerce.models.Producto;
import com.coder.ecommerce.models.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.coder.ecommerce.repository.RepositoryProducto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

// Aqui se aplican toda la logica de Negocio de los Productos
@Service
public class ProductoService {
    @Autowired
    private RepositoryProducto repositorio;

    public List<ProductoDTO> listar(){
        List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();

        for (Producto producto:repositorio.findAll()){
            ProductoDTO dtoProducto = new ProductoDTO();
            dtoProducto.setCodigo(producto.getCodigo());
            dtoProducto.setDescripcion(producto.getDescripcion());
            productosDTO.add(dtoProducto);
        }
        return productosDTO;
    }



    public ResponseEntity<String> grabar(Producto producto){
        if (producto.getDescripcion() == null || producto.getCodigo() == null)    {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        } else
        {
            try {
                this.repositorio.save(producto);
                return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
            } catch (Exception e) {
                return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
            }
        }
    }

    public ResponseEntity<String> actualizar(Long id, Producto producto){
        try {
            Producto updateProducto = this.repositorio.findById(id).get();
            updateProducto.setDescripcion(producto.getDescripcion());
            updateProducto.setCodigo(producto.getCodigo());
            updateProducto.setStock(producto.getStock());
            updateProducto.setPrecio(producto.getPrecio());
            this.repositorio.save(updateProducto);
            return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
        } catch (Exception e) {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        }
    }

    public ResponseEntity<String> borrar (Long id){
        try {
            Producto deleteProducto = this.repositorio.findById(id).get();
            this.repositorio.delete(deleteProducto);
            return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
        } catch (Exception e) {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        }
    }

    public ResponseEntity<String> actualizarStock (Long id, int unidadesVendidas){
        try {
                Producto updateProducto = this.repositorio.findById(id).get();
                updateProducto.setStock(updateProducto.getStock() - unidadesVendidas);
                this.repositorio.save(updateProducto);
                return  ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
        } catch (Exception e) {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        }
    }
}
