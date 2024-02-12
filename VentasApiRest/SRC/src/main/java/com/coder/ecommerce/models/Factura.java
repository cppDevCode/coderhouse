package com.coder.ecommerce.models;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

//Establezco Entidad para la tabla factura relacionada con la tabla cliente
@Entity
@Getter
@Setter
@Table(name="facturas")

public class Factura implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="idCliente")
    private Cliente cliente;

    @Column(name="creado_en")
    private Date fecha;

    @Column
    private Double total;

    @Column (name = "CANTIDAD_TOTAL_PRODUCTOS")
    private int cantidadTotalProductosVendidos;

    @OneToMany(mappedBy = "factura", fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
    private List<DetalleFactura> detalleFactura;

    public Factura(){}

    public Factura (Cliente clienteN, Double totalPesos){
        this.cliente = clienteN;
        this.total = totalPesos;
        this.fecha = new Date();
    }


}
