package com.coder.ecommerce.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//Establezco Entidad para la tabla Clientes

@Getter
@Setter
public class ClienteDTO {
    private String nombre;

    private String apellido;


    private String dni;

    public ClienteDTO(){}
    public ClienteDTO(String nom, String apel, String dni){
        this.nombre = nom;
        this.apellido = apel;
        this.dni = dni;
    }

}
