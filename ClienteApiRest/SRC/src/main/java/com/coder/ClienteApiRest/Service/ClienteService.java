package com.coder.ClienteApiRest.Service;

import com.coder.ClienteApiRest.Model.Cliente;
import com.coder.ClienteApiRest.Model.ClienteOutput;
import com.coder.ClienteApiRest.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.time.LocalDate;


@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repositorio;

    private int calculoEdad (LocalDate Fecha){
        int edad;

        edad = LocalDate.now().getYear() - Fecha.getYear();
        if (LocalDate.now().getMonthValue() < Fecha.getMonthValue()){
            edad -= 1;
        } else if (LocalDate.now().getMonth() == Fecha.getMonth() &&
                LocalDate.now().getDayOfMonth() < Fecha.getDayOfMonth()
        ) {
            edad -=1;
        }

        return edad;
    }
    public List<ClienteOutput> listar() {
        List<ClienteOutput> clientes = new ArrayList<ClienteOutput>();


        System.out.println("Listar:");
        for (Cliente cliente : this.repositorio.findAll()) {
            ClienteOutput clienteAux = new ClienteOutput();
            clienteAux.setAnios(this.calculoEdad(cliente.getFechaNacimiento()));
            clienteAux.setNombre(cliente.getNombre());
            clienteAux.setApellido(cliente.getApellido());
            System.out.println("Nombre: " + clienteAux.getNombre() + "\n" +
                    "Apellido: " + clienteAux.getApellido() + "\n" + "Años" +
                    clienteAux.getAnios());
            clientes.add(clienteAux);
        }

        return clientes;
    }

    public ResponseEntity<String> inicializarDatos(){
        this.repositorio.save(new Cliente("Alejandro","Baldres",LocalDate.parse("1984-07-14")));
        this.repositorio.save(new Cliente("Delfina","Baldres",LocalDate.parse("1983-07-14")));
        this.repositorio.save(new Cliente("Luciano","Baldres",LocalDate.parse("1982-07-14")));
        this.repositorio.save(new Cliente("Raquel","Baldres",LocalDate.parse("1981-07-14")));
        this.repositorio.save(new Cliente("Lisandro","Baldres",LocalDate.parse("1980-07-14")));
        return ResponseEntity.status(200).body("Operacion Sastisfactoria!");
    }
    public ResponseEntity<String> grabar (Cliente cliente){
        this.repositorio.save(cliente);
        return ResponseEntity.status(200).body("Operacion Sastifactoria");
    }
    public ClienteOutput tomarByID(Long id){
        Optional<Cliente> datoEncontrado = this.repositorio.findById(id);
        ClienteOutput cliente = new ClienteOutput();
        if (datoEncontrado.isPresent()) {
            System.out.println("Resultados para el ID: " + id);
            cliente.setAnios(this.calculoEdad(datoEncontrado.get().getFechaNacimiento()));
            cliente.setNombre(datoEncontrado.get().getNombre());
            cliente.setApellido(datoEncontrado.get().getApellido());
            System.out.println("Nombre: " + cliente.getNombre() + "\n" +
                    "Apellido: " + cliente.getApellido() + "\n" + "Años" +
                    cliente.getAnios());
        }
        return cliente;
    }
}
