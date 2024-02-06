package com.coder.ecommerce.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//Establezco Entidad para la tabla Clientes
@Entity
@Getter
@Setter
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String dni;
}
