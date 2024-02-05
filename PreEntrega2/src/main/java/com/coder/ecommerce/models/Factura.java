package com.coder.ecommerce.models;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;

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

    @Column(name="id_cliente")

    private Long idCliente;

    @Column(name="creado_en")
    private LocalDateTime creadoEn;

    @Column
    private Double total;

    @OneToMany(mappedBy = "factura", fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
    private List<DetalleFactura> detalleFactura;

    public Factura(){}

    public List<DetalleFactura> getDetalleFactura() {
        return this.detalleFactura;
    }


}
