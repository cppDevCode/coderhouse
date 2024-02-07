package com.coder.ecommerce.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//Establezco Entidad para la tabla productos relacionada con la tabla detalleFactura
@Entity
@Getter
@Setter
@Table(name="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descripcion;

    @Column
    private String codigo;

    @Column
    private int stock;

    @Column
    private Double precio;
}
