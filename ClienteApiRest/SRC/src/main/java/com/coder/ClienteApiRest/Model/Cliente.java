package com.coder.ClienteApiRest.Model;
import ch.qos.logback.core.net.server.Client;
import lombok.Setter;
import lombok.Getter;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name="clientes")
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column (name="fecha_nacimiento")
    private LocalDate fechaNacimiento;


//@Transient permite que el atributo edad no sea persistente, por lo que no crea la columna
    @Transient
    private int anios;

    public Cliente(){}
    public Cliente(String nom, String apel, LocalDate fn){
        this.nombre = nom;
        this.apellido = apel;
        this.fechaNacimiento = fn;
    }

}
