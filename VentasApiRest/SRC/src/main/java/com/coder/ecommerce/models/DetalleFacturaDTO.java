package com.coder.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DetalleFacturaDTO {
    private int cantidad;
    private ProductoDTO producto;
    private Double precioProducto;

}
