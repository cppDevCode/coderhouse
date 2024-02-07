package com.coder.ecommerce.models;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;

//Establezco Entidad para la tabla factura relacionada con la tabla cliente
@Entity
@Getter
@Setter
@Table(name="facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="id_cliente")

    private Long idCliente;

    @Column(name="creado_en")
    private LocalDateTime creadoEn;

    @Column
    private Double total;
}
