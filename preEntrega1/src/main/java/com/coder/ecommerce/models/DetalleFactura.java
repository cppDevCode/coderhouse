package com.coder.ecommerce.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//Establezco Entidad para la tabla detallefactura relacionada con tablas facturas y productos
@Entity
@Getter
@Setter
@Table(name="detallefactura")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="id_factura")
    private Long idFactura;

    @Column
    private int cantidad;

    @Column (name="id_producto")
    private Long idProducto;

    @Column
    private Double precio;
}
