package com.coder.ecommerce.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

//Establezco Entidad para la tabla detallefactura relacionada con tablas facturas y productos
@Entity
@Getter
@Setter
@Table(name="detallefactura")

public class DetalleFactura implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int cantidad;

    @ManyToOne
    @JoinColumn(name="idProducto")
    private Producto Producto;

    @Column
    private Double precioProducto;

    @ManyToOne
    @JoinColumn(name = "FK_FACTURA", nullable = false, updatable = false)
    private Factura factura;

    public DetalleFactura(){}
    public DetalleFactura(int cantidadP, Double subtotalF, Factura f) {
        this.cantidad = cantidadP;
        this.precioProducto = subtotalF;
        this.factura = f;
    }
}
