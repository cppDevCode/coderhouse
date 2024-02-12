package com.coder.ecommerce.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

//Establezco Entidad para la tabla Clientes
@Entity
@Getter
@Setter
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String dni;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Factura> facturas = new ArrayList<>();

    public Cliente(){}
    public Cliente(String nom, String apel, String dni){
        this.nombre = nom;
        this.apellido = apel;
        this.dni = dni;
    }
}
