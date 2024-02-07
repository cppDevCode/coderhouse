package com.coder.ecommerce.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

//Establezco Entidad para la tabla productos relacionada con la tabla detalleFactura
@Entity
@Getter
@Setter
@Table(name="productos")
public class Producto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column
    private String descripcion;

    @Column
    private String codigo;

    @Column
    private int stock;

    @Column
    private Double precio;


    public Producto(){}
    public Producto (String descripcionS, String codigoS, int stockI, Double precioD ){
        this.descripcion = descripcionS;
        this.codigo = codigoS;
        this.stock = stockI;
        this.precio = precioD;
    }


}
