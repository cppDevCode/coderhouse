package com.coder.ecommerce.models;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FacturaDTO {
    private Long id;
    private ClienteDTO cliente;

    private LocalDateTime creadoEn;
    private Double total;
    private List<DetalleFacturaDTO> detalleFactura;

    private int cantidadTotalProductosVendidos;

    public FacturaDTO(){}

}
