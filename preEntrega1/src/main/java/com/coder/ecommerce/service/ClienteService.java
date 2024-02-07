package com.coder.ecommerce.service;

import com.coder.ecommerce.models.Cliente;
import com.coder.ecommerce.repository.RepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

//Aqui se aplican toda la logica de Negocio de Clientes


@Service
public class ClienteService {
    @Autowired
    private RepositoryCliente repositorio;

    public List<Cliente> listar (){
        return this.repositorio.findAll();
    }

    public ResponseEntity<String> grabar(Cliente cliente){
        if (cliente.getNombre() == null || cliente.getApellido() == null ||
                cliente.getDni() == null)    {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        } else
        {
            try {
                this.repositorio.save(cliente);
                return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
            } catch (Exception e) {
                return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
            }
        }
    }

    public ResponseEntity<String> actualizar(Long id, Cliente cliente){
        try {
            Cliente updateCliente = this.repositorio.findById(id).get();
            updateCliente.setNombre(cliente.getNombre());
            updateCliente.setApellido(cliente.getApellido());
            updateCliente.setDni(cliente.getDni());
            this.repositorio.save(updateCliente);
            return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
        } catch (Exception e) {
        return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        }
    }

    public ResponseEntity<String> borrar(Long id){
        try{
            Cliente deleteCliente = this.repositorio.findById(id).get();
            this.repositorio.delete(deleteCliente);
            return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
        } catch (Exception e) {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        }
    }

}